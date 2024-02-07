pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    //将build-logic里的libs.versions.toml提供给整个项目使用
    versionCatalogs {
        create("buildLibs") {
            from(files("./build-logic/gradle/libs.versions.toml"))
        }
        create("composeLibs") {
            from(files("./build-logic/gradle/composeLibs.versions.toml"))
        }
    }
}

rootProject.name = "BuildLogicLib"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
