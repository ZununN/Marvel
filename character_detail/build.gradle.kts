plugins {
    id("android_library")
    id("android_compose")
}

android {
    namespace = "kz.zunun.character_detail"
}

dependencies {
    implementation(projects.uiKit)
    implementation(projects.domain)
    implementation(projects.core)
}