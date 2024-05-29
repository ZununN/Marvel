plugins {
    id("android_library")
    id("android_compose")
}

android {
    namespace = "kz.zunun.ui_kit"

}

dependencies {

    api (libs.decompose)
    api (libs.decompose.ext)
    implementation(libs.coil.compose)
    api(libs.androidx.core.ktx)
    api(libs.androidx.lifecycle.runtime.ktx)
    api(libs.androidx.activity.compose)
    api(platform(libs.androidx.compose.bom))
    api(libs.androidx.ui)
    api(libs.androidx.ui.graphics)
    api(libs.androidx.ui.tooling.preview)
    api(libs.androidx.material3)
    api(libs.koin.androidx.compose)
    api(libs.androidx.lifecycle.runtime.compose)
}