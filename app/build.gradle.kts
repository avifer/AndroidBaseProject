import FunctionsGradle.BuildType.RELEASE
import FunctionsGradle.getFileStore
import FunctionsGradle.getKeyAlias
import FunctionsGradle.getKeyPassword
import FunctionsGradle.getStorePassword
import FunctionsGradle.getVersionCode

plugins {
    id(Plugins.ANDROID_APPLICATION)
    id(Plugins.KOTLIN_ANDROID)
    id(Plugins.KOTLIN_KAPT)
    id(Plugins.DAGGER_HILT)
    id(Plugins.JETBRAINS_KOTLIN)
    id(Plugins.GMS_GOOGLE_SERVICES)
    id(Plugins.FIREBASE_CRASHLYTICS)
}

android {
    namespace = ConfigApp.APPLICATION_ID
    compileSdk = ConfigApp.COMPILE_SDK

    defaultConfig {
        applicationId = ConfigApp.APPLICATION_ID
        minSdk = ConfigApp.MIN_SDK
        targetSdk = ConfigApp.TARGET_SDK
        versionCode = getVersionCode()
        versionName = ConfigApp.VERSION_NAME

        vectorDrawables {
            useSupportLibrary = true
        }
    }
    signingConfigs {
        create("release") {
            storeFile = getFileStore(RELEASE)
            storePassword = getStorePassword(RELEASE)
            keyAlias = getKeyAlias(RELEASE)
            keyPassword = getKeyPassword(RELEASE)
        }
    }
    buildTypes {
        getByName("debug") {
            applicationIdSuffix = ".debug"
            isMinifyEnabled = false
            isDebuggable = true
            manifestPlaceholders["crashlyticsCollectionEnabled"] = true
            manifestPlaceholders["analyticsCollectionEnabled"] = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
        getByName("release") {
            isMinifyEnabled = false
            isDebuggable = false
            manifestPlaceholders["crashlyticsCollectionEnabled"] = true
            manifestPlaceholders["analyticsCollectionEnabled"] = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
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
}

dependencies {
    implementation(project(Modules.COMMON))
    implementation(project(Modules.DATA))
    implementation(project(Modules.DOMAIN))
    implementation(project(Modules.FEATURE_SPLASH))
    implementation(project(Modules.FEATURE_BLOCKCHAIN))

    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.activity:activity-compose:1.5.1")
    implementation(platform("androidx.compose:compose-bom:2022.10.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2022.10.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")


    implementation(Dependencies.Google.FIREBASE_CRASHLYTICS)
    implementation(Dependencies.Google.FIREBASE_ANALYTICS)
    implementation(Dependencies.Google.FIREBASE_CONFIG)

    implementation(Dependencies.Androidx.ROOM_RUNTIME)
    implementation(Dependencies.Androidx.ROOM_KTX)
    kapt(Dependencies.Androidx.ROOM_COMPILER)

    implementation(Dependencies.Google.HILT_ANDROID)
    kapt(Dependencies.Google.HILT_ANDROID_COMPILER)
}