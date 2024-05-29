package kz.zunun.marvel

import android.os.Parcelable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import kotlinx.parcelize.Parcelize
import kz.zunun.character_detail.CharacterDetailComponent
import kz.zunun.characters.CharactersComponent


class RootComponent(
    componentContext: ComponentContext,
) : ComponentContext by componentContext {

    private val navigator = StackNavigation<Config>()
    val stack: Value<ChildStack<Config, ComponentContext>> = childStack(
        source = navigator,
        initialConfiguration = Config.CharactersScreen,
        handleBackButton = true,
        childFactory = ::child
    )

    private fun child(
        config: Config,
        componentContext: ComponentContext,
    ) = when (config) {
        is Config.CharacterDetails -> CharacterDetailComponent(componentContext, config.id)
        is Config.CharactersScreen -> CharactersComponent(componentContext) {
            navigator.push(Config.CharacterDetails(it))
        }
    }

}

sealed interface Config : Parcelable {

    @Parcelize
    data object CharactersScreen : Config

    @Parcelize
    data class CharacterDetails(val id: Int) : Config
}
