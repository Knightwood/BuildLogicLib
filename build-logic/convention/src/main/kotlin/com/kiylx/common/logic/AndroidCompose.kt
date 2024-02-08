package com.kiylx.common.logic

import com.android.build.api.dsl.CommonExtension
import com.kiylx.common.dependences.AndroidBuildCode
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

/**
 * Configure Compose-specific options
 */
internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *>,
) {
    commonExtension.apply {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = AndroidBuildCode.compose_compiler_version
//            kotlinCompilerExtensionVersion = composeLibs.findVersion("androidxComposeCompiler").get().toString()
        }
        packaging {
            resources {
                excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }
        }
        dependencies {
//            val bom = composeLibs.findLibrary("androidx-compose-bom").get()
//            add("implementation", platform(bom))
//            add("androidTestImplementation", platform(bom))
            val compose_bom="2024.01.00"
            val composeBom = platform("androidx.compose:compose-bom:${compose_bom}")
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
            extensions.getByType<VersionCatalogsExtension>().named("composeLibs")
//            implementation(composeLibs.findLibrary(ComposeLibsName.lifecycleViewModel).get())
            // Optional - Integration with LiveData
            implementation("androidx.compose.runtime:runtime-livedata")

            //test
            androidTestImplementation(platform("androidx.compose:compose-bom:${compose_bom}"))

        }

//        testOptions {
//            unitTests {
//                // For Robolectric
//                isIncludeAndroidResources = true
//            }
//        }
    }

//    tasks.withType<KotlinCompile>().configureEach {
//        kotlinOptions {
//            freeCompilerArgs = freeCompilerArgs + buildComposeMetricsParameters()
//        }
//    }
}

private fun Project.buildComposeMetricsParameters(): List<String> {
    val metricParameters = mutableListOf<String>()
    val enableMetricsProvider = project.providers.gradleProperty("enableComposeCompilerMetrics")
    val relativePath = projectDir.relativeTo(rootDir)
    val buildDir = layout.buildDirectory.get().asFile
    val enableMetrics = (enableMetricsProvider.orNull == "true")
    if (enableMetrics) {
        val metricsFolder = buildDir.resolve("compose-metrics").resolve(relativePath)
        metricParameters.add("-P")
        metricParameters.add(
            "plugin:androidx.compose.compiler.plugins.kotlin:metricsDestination=" + metricsFolder.absolutePath
        )
    }

    val enableReportsProvider = project.providers.gradleProperty("enableComposeCompilerReports")
    val enableReports = (enableReportsProvider.orNull == "true")
    if (enableReports) {
        val reportsFolder = buildDir.resolve("compose-reports").resolve(relativePath)
        metricParameters.add("-P")
        metricParameters.add(
            "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=" + reportsFolder.absolutePath
        )
    }
    return metricParameters.toList()
}