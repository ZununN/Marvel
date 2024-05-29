package kz.zunun.data.character

import kz.zunun.data.characters.toDto
import kz.zunun.data.characters.toModel
import kz.zunun.data.core.dataBase.Character
import kz.zunun.data.core.dataBase.CharactersDatabase
import kz.zunun.data.core.dataModule
import kz.zunun.data.core.network.ApiService
import kz.zunun.domain.character.CharacterLocalDataSource
import kz.zunun.domain.character.CharacterRemoteDataSource
import kz.zunun.domain.character.CharacterRepository
import kz.zunun.domain.characters.models.CharacterItemModel
import kz.zunun.domain.common.Conclusion
import kz.zunun.domain.common.apiCall
import kz.zunun.domain.common.onSuccess

class CharacterRepositoryImpl(
    private val localDataSource: CharacterLocalDataSource,
    private val remoteDataSource: CharacterRemoteDataSource,
) : CharacterRepository {
    override suspend fun fetchCharacter(id: Int): Conclusion<CharacterItemModel> {

        val localData = localDataSource.fetchCharacter(id)
        return if (localData == null) {
            remoteDataSource.fetchCharacter(id).onSuccess {
                localDataSource.savaCharacter(model = it)
            }
        } else {
            Conclusion.Success(localData)
        }
    }
}

class CharacterRemoteDataSourceImpl(private val service: ApiService) : CharacterRemoteDataSource {
    override suspend fun fetchCharacter(id: Int) = apiCall {
        service.getCharacter(id).toModel().first()
    }
}

class CharacterLocalDataSourceImpl(val database: CharactersDatabase) : CharacterLocalDataSource {
    override suspend fun fetchCharacter(id: Int): CharacterItemModel? {
        return database.dao().getCharacterById(id).toModel()
    }

    override suspend fun savaCharacter(model: CharacterItemModel) {
        database.dao().insert(model.toDto())
    }
}