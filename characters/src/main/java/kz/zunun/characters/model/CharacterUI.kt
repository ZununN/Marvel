package kz.zunun.characters.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kz.zunun.domain.characters.models.CharacterItemModel

@Parcelize
data class CharacterUI(
    val name: String,
    val description: String?,
    val imageUrl: String,
    val id: Int,
) : Parcelable

fun CharacterItemModel.toUi(): CharacterUI {
    return CharacterUI(
        id = this.id,
        name = this.name,
        description = this.description,
        imageUrl = this.imageUrl
    )
}
