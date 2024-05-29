package kz.zunun.marvel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import kz.zunun.character_detail.CharacterDetailComponent
import kz.zunun.character_detail.CharacterDetailScreen
import kz.zunun.characters.CharactersComponent
import kz.zunun.characters.CharactersScreen
import kz.zunun.ui_kit.theme.MarvelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val root = rootComponent()
            MarvelTheme {
                Children(root.stack) {
                    when (val component = it.instance) {
                        is CharactersComponent -> CharactersScreen(component)
                        is CharacterDetailComponent -> CharacterDetailScreen(component)
                    }
                }
            }
        }
    }
}