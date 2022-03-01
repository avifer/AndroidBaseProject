plugins {
    id(Plugins.ANDROID_APPLICATION)
    id(Plugins.KOTLIN_ANDROID)
    id(Plugins.KOTLIN_KAPT)
    id(Plugins.DAGGER_HILT)
    id(Plugins.JETBRAINS_KOTLIN)
    id(Plugins.NAVIGATION_SAFEARGS)
}

android {
    compileSdk = ConfigApp.COMPILE_SDK
    defaultConfig {
        applicationId = ConfigApp.APPLICATION_ID
        minSdk = ConfigApp.MIN_SDK
        targetSdk = ConfigApp.TARGET_SDK
        versionCode = ConfigApp.VERSION_CODE
        versionName = ConfigApp.VERSION_NAME

        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    viewBinding {
        isEnabled = true
    }
}

dependencies {
    implementation(project(Modules.COMMON))
    implementation(project(Modules.DATA))
    implementation(project(Modules.DOMAIN))
    implementation(project(Modules.NAVIGATION))
    implementation(project(Modules.FEATURE_SPLASH))
    implementation(project(Modules.FEATURE_BLOCKCHAIN))

    implementation(Dependencies.Androidx.CORE_KOTLIN)

    implementation(Dependencies.Androidx.LIFECYCLE_RUNTIME_KOTLIN)
    implementation(Dependencies.Material.MATERIAL)
    implementation(Dependencies.Androidx.CONSTRAINT_LAYOUT)
    implementation(Dependencies.Androidx.APPCOMPAT)

    implementation(Dependencies.Androidx.NAVIGATION_FRAGMENT_KOTLIN)
    implementation(Dependencies.Androidx.NAVIGATION_UI_KOTLIN)

    implementation(Dependencies.Androidx.ROOM_RUNTIME)
    implementation(Dependencies.Androidx.ROOM_KTX)
    kapt(Dependencies.Androidx.ROOM_COMPILER)

    implementation(Dependencies.Google.HILT_ANDROID)
    kapt(Dependencies.Google.HILT_ANDROID_COMPILER)
}