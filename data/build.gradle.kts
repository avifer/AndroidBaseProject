plugins {
    id(Plugins.ANDROID_LIBRARY)
    id(Plugins.KOTLIN_ANDROID)
    id(Plugins.KOTLIN_KAPT)
    id(Plugins.DAGGER_HILT)
}

android {
    namespace = "es.avifer.abp.data"
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

    implementation(Dependencies.Androidx.ROOM_RUNTIME)
    implementation(Dependencies.Androidx.ROOM_KTX)
    kapt(Dependencies.Androidx.ROOM_COMPILER)

    implementation(Dependencies.Squareup.RETROFIT2)
    implementation(Dependencies.Google.GSON)
    implementation(Dependencies.Squareup.CONVERTER_GSON)
    implementation(Dependencies.Squareup.LOGGING_INTERCEPTOR)
    implementation(Dependencies.Squareup.OKHTTPS)

    implementation(Dependencies.Google.HILT_ANDROID)
    kapt(Dependencies.Google.HILT_ANDROID_COMPILER)
}