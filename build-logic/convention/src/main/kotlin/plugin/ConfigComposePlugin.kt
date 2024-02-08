package plugin

import com.android.build.api.dsl.ApplicationExtension
import com.kiylx.common.dependences.AndroidBuildCode
import com.kiylx.common.logic.configComposeWithBom
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure



//compose的通用构建逻辑
class ConfigComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        println("配置compose")
        with(target) {
            //配置compose
            extensions.configure<ApplicationExtension> {
                buildFeatures {
                    compose = true
                }
                composeOptions {
                    kotlinCompilerExtensionVersion = AndroidBuildCode.compose_compiler_version
                }
                packaging {
                    resources {
                        excludes += "/META-INF/{AL2.0,LGPL2.1}"
                    }
                }
            }
            configComposeWithBom(AndroidBuildCode.compose_bom)
//            pluginManager.apply("com.android.application")
//
//            val extension = extensions.getByType<ApplicationExtension>()
//            configureAndroidCompose(extension)
        }
    }
}