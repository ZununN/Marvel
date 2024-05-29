plugins {
    `kotlin-dsl`
}

group = "kz.zunun.marvel.buildlogic"


dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidLibrary") {
            id = "android_library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidCompose") {
            id = "android_compose"
            implementationClass = "AndroidComposeConventionPlugin"
        }
    }
}