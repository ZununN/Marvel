plugins {
    id("android_library")
}

android {
    namespace = "kz.zunun.core"
}

dependencies {

    api(libs.kotlinx.coroutines.core)
    api(platform(libs.koin.bom))
    api(libs.koin.core)
    api(libs.koin.android)
    api(libs.decompose)

}