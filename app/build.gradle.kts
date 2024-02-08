/*
import com.kiylx.dependences.androidTest
import com.kiylx.dependences.kotlinProject


plugins {
    id("com.kiylx.build_logic.configAppModule")
//    id("com.kiylx.build_logic.configCompose")
    alias(buildLibs.plugins.kiylx.buildLogic.configCompose)
}

android {
    namespace = "com.kiylx.common.buildlogiclib"

    defaultConfig {
        applicationId = "com.kiylx.common.buildlogiclib"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildToolsVersion = "33.0.2"
}
dependencies {
    implementation(buildLibs.bundles.bundleAndroidx)
    kotlinProject()
    androidTest()
}
*/
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    alias(buildLibs.plugins.kiylx.buildLogic.configCompose)
}

android {
    namespace = "com.kiylx.common.buildlogiclib"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.kiylx.common.buildlogiclib"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("androidx.activity:activity-compose:1.7.0")
    implementation(platform("androidx.compose:compose-bom:2024.01.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}