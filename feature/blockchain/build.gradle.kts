plugins {
    id(Plugins.ANDROID_LIBRARY)
    id(Plugins.KOTLIN_ANDROID)
    id(Plugins.KOTLIN_KAPT)
    id(Plugins.DAGGER_HILT)
    id(Plugins.JETBRAINS_KOTLIN)
}

android {
    namespace = "es.avifer.abp.feature.blockchain"
    compileSdk = ConfigApp.COMPILE_SDK
    defaultConfig {
        minSdk = ConfigApp.MIN_SDK
        targetSdk = ConfigApp.TARGET_SDK
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }
}

dependencies {
    implementation(project(Modules.COMMON))
    implementation(project(Modules.DOMAIN))

    implementation(Dependencies.Androidx.FRAGMENT)

    implementation(Dependencies.Androidx.LIFECYCLE_RUNTIME_KOTLIN)
    implementation(Dependencies.Androidx.CONSTRAINT_LAYOUT)
    implementation(Dependencies.Androidx.SWIPE_REFRESH)

    implementation(Dependencies.Androidx.NAVIGATION_FRAGMENT_KOTLIN)
    implementation(Dependencies.Androidx.NAVIGATION_UI_KOTLIN)

    implementation(Dependencies.Google.HILT_ANDROID)
    kapt(Dependencies.Google.HILT_ANDROID_COMPILER)
}
