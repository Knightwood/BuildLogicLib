package com.kiylx.common.logic


import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.getByType

//快速访问libs和composeLibs的扩展属性
val Project.libs
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

val Project.composeLibs
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("composeLibs")

//引入依赖
fun DependencyHandlerScope.implementation(str: Any) = "implementation"(str)

fun DependencyHandlerScope.api(str: Any) = "api"(str)

fun DependencyHandlerScope.debugImplementation(str: Any) = "debugImplementation"(str)

fun DependencyHandlerScope.androidTestImplementation(str: Any) = "androidTestImplementation"(str)

//带版本号的
fun DependencyHandlerScope.implementation(str: String,ver:String) = "implementation"("$str:$ver")

fun DependencyHandlerScope.api(str: String,ver:String) = "api"(str)

fun DependencyHandlerScope.debugImplementation(str: String,ver:String) = "debugImplementation"("$str:$ver")

fun DependencyHandlerScope.androidTestImplementation(str: String,ver:String) = "androidTestImplementation"("$str:$ver")

