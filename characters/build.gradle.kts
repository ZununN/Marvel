plugins {
    id("android_library")
    id("android_compose")
    id("kotlin-parcelize")
}

android {
    namespace = "kz.zunun.characters"
}

dependencies {
    implementation(projects.uiKit)
    implementation(projects.domain)
    implementation(projects.core)
}