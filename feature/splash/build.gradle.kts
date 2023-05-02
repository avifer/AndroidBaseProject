plugins {
    id(Plugins.ANDROID_LIBRARY)
    id(Plugins.KOTLIN_ANDROID)
    id(Plugins.JETBRAINS_KOTLIN)
    id(Plugins.NAVIGATION_SAFEARGS)
}

android {
    compileSdk = ConfigApp.COMPILE_SDK
    defaultConfig {
        minSdk = ConfigApp.MIN_SDK
        targetSdk = ConfigApp.TARGET_SDK
    }
    viewBinding {
        isEnabled = true
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}
dependencies {
    implementation(project(Modules.COMMON))

    implementation(Dependencies.Androidx.COMPOSE_UI)
    implementation(Dependencies.Androidx.COMPOSE_UI_TOOLING_PREVIEW)
    implementation(Dependencies.Androidx.ACTIVITY_COMPOSE)
    implementation(Dependencies.Androidx.COMPOSE_MATERIAL)

    implementation("androidx.compose.material:material-icons-extended:1.4.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    implementation("androidx.navigation:navigation-compose:2.5.3")


    implementation(Dependencies.Androidx.LIFECYCLE_RUNTIME_KOTLIN)
    implementation(Dependencies.Androidx.CONSTRAINT_LAYOUT)

    implementation(Dependencies.Androidx.FRAGMENT)
    implementation(Dependencies.Google.FIREBASE_CONFIG)

    implementation(Dependencies.Androidx.NAVIGATION_FRAGMENT_KOTLIN)
    implementation(Dependencies.Androidx.NAVIGATION_UI_KOTLIN)
}
