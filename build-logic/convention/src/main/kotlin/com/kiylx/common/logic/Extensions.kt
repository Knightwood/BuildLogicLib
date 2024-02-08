package com.kiylx.common.logic

import com.android.build.api.dsl.ApplicationExtension
import com.kiylx.common.dependences.AndroidX
import com.kiylx.common.dependences.Kotlin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

fun DependencyHandlerScope.kotlinProject() {
    implementation(Kotlin.libs.coroutines.core)
    implementation(Kotlin.libs.coroutines.android)
}

fun DependencyHandlerScope.androidTest() {
    "testImplementation"(AndroidX.libs.test.jUnit)
    "androidTestImplementation"(AndroidX.libs.test.androidJUnit)
    "androidTestImplementation"(AndroidX.libs.test.espresso)
}

fun Project.configComposeWithBom(
    composeBomVersion: String
) {
    val that =this
    extensions.getByType<ApplicationExtension>().apply {
        dependencies {
            val composeBom = platform("androidx.compose:compose-bom:${composeBomVersion}")
            implementation(composeBom)
            androidTestImplementation(composeBom)

            // Choose one of the following:
            // Material Design 3
            implementation("androidx.compose.material3:material3")
            // or Material Design 2
//          implementation("androidx.compose.material:material")
            // or skip Material Design and build directly on top of foundational components
//          implementation("androidx.compose.foundation:foundation")
            // or only import the main APIs for the underlying toolkit systems,
            // such as input and measurement/layout
//          implementation("androidx.compose.ui:ui")

            // Android Studio Preview support
            implementation("androidx.compose.ui:ui-tooling-preview")
            debugImplementation("androidx.compose.ui:ui-tooling")

            // UI Tests
            androidTestImplementation("androidx.compose.ui:ui-test-junit4")
            debugImplementation("androidx.compose.ui:ui-test-manifest")

            // Optional - Included automatically by material, only add when you need
            // the icons but not the material library (e.g. when using Material3 or a
            // custom design system based on Foundation)
            implementation("androidx.compose.material:material-icons-core")
            // Optional - Add full set of material icons
//          implementation("androidx.compose.material:material-icons-extended")
            // Optional - Add window size utils
            implementation("androidx.compose.material3:material3-window-size-class")
            // Optional - Integration with activities
            implementation("androidx.activity:activity-compose:1.7.2")
            // Optional - Integration with ViewModels
            that.extensions.getByType<VersionCatalogsExtension>().named("buildLibs")
//            implementation(composeLibs.findLibrary(ComposeLibsName.lifecycleViewModel).get())
            // Optional - Integration with LiveData
            implementation("androidx.compose.runtime:runtime-livedata")

            //test
            androidTestImplementation(platform("androidx.compose:compose-bom:${composeBomVersion}"))

        }

    }
}