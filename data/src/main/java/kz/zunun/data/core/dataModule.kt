package kz.zunun.data.core

import androidx.room.Room
import kz.zunun.data.character.CharacterLocalDataSourceImpl
import kz.zunun.data.character.CharacterRemoteDataSourceImpl
import kz.zunun.data.character.CharacterRepositoryImpl
import kz.zunun.data.characters.CharactersRepositoryImpl
import kz.zunun.data.core.dataBase.CharactersDatabase
import kz.zunun.data.core.network.ApiService
import kz.zunun.data.core.network.httpClientAndroid
import kz.zunun.domain.character.CharacterLocalDataSource
import kz.zunun.domain.character.CharacterRemoteDataSource
import kz.zunun.domain.character.CharacterRepository
import kz.zunun.domain.characters.CharactersRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataModule = module {
    single { httpClientAndroid }
    single { ApiService(get()) }
    single {
        Room.databaseBuilder(
            androidApplication(),
            CharactersDatabase::class.java, CharactersDatabase.NAME
        ).build()
    }
    factory<CharactersRepository> { CharactersRepositoryImpl(get()) }
    factory<CharacterRepository> { CharacterRepositoryImpl(get(), get()) }
    factory<CharacterLocalDataSource> { CharacterLocalDataSourceImpl(get()) }
    factory<CharacterRemoteDataSource> { CharacterRemoteDataSourceImpl(get()) }
}
