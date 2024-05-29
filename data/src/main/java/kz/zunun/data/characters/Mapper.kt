package kz.zunun.data.characters

import kz.zunun.data.characters.models.CharacterInfo
import kz.zunun.data.characters.models.CharactersResponse
import kz.zunun.data.core.dataBase.Character
import kz.zunun.domain.characters.models.CharacterItemModel
import kz.zunun.domain.common.PagingData


fun CharactersResponse.toModel(): List<CharacterItemModel> {
    return this.data.results.map { it.toModel() }
}


fun CharacterInfo.toModel() = CharacterItemModel(
    id = this.id,
    name = this.name,
    description = this.description.ifEmpty { null },
    imageUrl = "${thumbnail.path}.${thumbnail.extension}".replace("http", "https")
)

internal fun CharactersResponse.toPagingModel(): PagingData<CharacterItemModel> = PagingData(
    count = this.data.count,
    limit = this.data.limit,
    offset = this.data.offset,
    data = this.data.results.map { it.toModel() },
    total = this.data.total
)

internal fun CharacterItemModel.toDto() =
    Character(id = id, name = name, description = description, imageUrl = imageUrl)


internal fun Character?.toModel(): CharacterItemModel? {
    if (this == null) return null
    return CharacterItemModel(
        id = this.id, name = this.name, description = this.description, imageUrl = this.imageUrl
    )
}

