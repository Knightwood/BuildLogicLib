import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

group = "com.kiylx.build_logic"

// Configure the build-logic plugins to target JDK 17
// This matches the JDK used to build the project, and is not related to what is running on device.
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
    withSourcesJar()
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.android.gradlePlugin)

    //Make version catalog more type safe
//    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
//    implementation(files(composeLibs.javaClass.superclass.protectionDomain.codeSource.location))
}
//tasks {
//    validatePlugins {
//        enableStricterValidation = true
//        failOnWarning = true
//    }
//}

gradlePlugin {

    plugins {
        register("ConfigComposePlugin") {
            id = "com.kiylx.build_logic.configCompose"
            implementationClass = "plugin.ConfigComposePlugin"
        }
        register("ConfigComposeModulePlugin") {
            id = "com.kiylx.build_logic.configComposeModule"
            implementationClass = "plugin.ConfigComposeModulePlugin"
        }
        register("BasicBuildLogicPlugin") {
            id = "com.kiylx.build_logic.configAppModule"
            implementationClass = "plugin.BasicBuildLogicPlugin"
        }
    }
}
