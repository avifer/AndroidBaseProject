plugins {
    id(Plugins.ANDROID_LIBRARY)
    id(Plugins.KOTLIN_ANDROID)
    id(Plugins.JETBRAINS_KOTLIN)
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
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
dependencies {
    implementation(project(Modules.DOMAIN))

    implementation("androidx.core:core-ktx:1.10.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.1")
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

    implementation(Dependencies.Androidx.CONSTRAINT_LAYOUT)
    implementation(Dependencies.Androidx.APPCOMPAT)
    implementation(Dependencies.Androidx.FRAGMENT)

    implementation(Dependencies.Google.FIREBASE_CONFIG)

    implementation(Dependencies.Androidx.NAVIGATION_FRAGMENT_KOTLIN)
    implementation(Dependencies.Androidx.NAVIGATION_UI_KOTLIN)
}
