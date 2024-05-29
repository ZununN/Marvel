package kz.zunun.marvel

import kz.zunun.characters.charactersModule
import kz.zunun.data.core.dataModule

import org.koin.dsl.module

val appModule = module {
    includes(dataModule,charactersModule)
}
