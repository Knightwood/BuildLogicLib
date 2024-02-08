package plugin

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import com.kiylx.common.dependences.AndroidBuildCode
import com.kiylx.common.logic.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType


//compose的通用构建逻辑
class ConfigComposeModulePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        println("配置compose")
        with(target) {
            //配置compose
            with(target) {
                pluginManager.apply("com.android.library")

                val extension = extensions.getByType<LibraryExtension>()
                configureAndroidCompose(extension)
            }
        }
    }
}