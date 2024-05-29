plugins {
    id("android_library")
    id("kotlinx-serialization")
    id("com.google.devtools.ksp")
}

android {
    namespace = "kz.zunun.data"
}

dependencies {
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.runtime)

    implementation(projects.core)
    implementation(projects.domain)
    api(libs.ktor.client.serialization)
    api(libs.ktor.client.logging)
    api(libs.ktor.client.android)
    api(libs.ktor.client.content.negotiation)
    api(libs.ktor.serialization.kotlinx.json)
}