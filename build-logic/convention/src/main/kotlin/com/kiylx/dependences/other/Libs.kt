@file:Suppress(
    "unused",
    "SpellCheckingInspection",
)

package com.kiylx.dependences.other



object Coil {
    private const val coilVersion = "2.2.2"
    const val coil = "io.coil-kt:coil:$coilVersion"
}



object Excludes {
    const val jniExclude = "/okhttp3/internal/publicsuffix/*"
    val listExclude: List<String> = listOf(
        "/DebugProbesKt.bin",
        "/kotlin/**.kotlin_builtins",
        "/kotlin/**.kotlin_metadata",
        "/META-INF/**.kotlin_module",
        "/META-INF/**.pro",
        "/META-INF/**.version",
        "/okhttp3/internal/publicsuffix/*"
    )
}


//==========================================================
object Jackson {
    const val core = "com.fasterxml.jackson.core:jackson-core:2.14.2"
}

object Others {
    const val libsu = "com.github.topjohnwu.libsu:core:5.0.4"
    const val zoomage = "com.jsibbold:zoomage:1.3.1"
    private const val shizukuVersion = "13.0.0"
    const val shizukuApi = "dev.rikka.shizuku:api:$shizukuVersion"
    const val shizukuProvider = "dev.rikka.shizuku:provider:$shizukuVersion"
}
object Tools {
    //崩溃日志上传
    const val logReport = "com.github.wenmingvs:LogReport:1.0.3"

    //内存泄漏分析
    const val leakcanary = "com.squareup.leakcanary:leakcanary-android:2.8.1"

    //log库（不是okhttp的log库）
    const val logger = "com.orhanobut:logger:2.2.0"

    //crash捕获库
    const val crasher = "me.jfenn:crasher:0.0.2"

    //工具库
    const val utilcodex = "com.blankj:utilcodex:1.31.0"

    const val mmkv ="com.tencent:mmkv:1.3.0"
    //生成material design 3 的主题色
    const val m3Color ="com.github.Kyant0:m3color:2023.8.1"
    //svg
    const val svgSupport ="com.caverock:androidsvg-aar:1.4"


    //权限申请
    const val perms = "com.guolindev.permissionx:permissionx:1.6.1"

    //页面切换
    const val loadsir = "com.kingja.loadsir:loadsir:1.3.8"

    //载图
    //implementation("com.github.bumptech.glide:glide:4.10.0")
    //annotationProcessor("com.github.bumptech.glide:compiler:4.10.0")
    object SmartRefresh {
        //刷新
        const val refreshKernal = "io.github.scwang90:refresh-layout-kernel:2.0.5"
        const val refreshMaterialStyle = "io.github.scwang90:refresh-header-material:2.0.5"
    }
    //高德地图
    //implementation("com.amap.api:map2d:6.0.0")
    //implementation("com.amap.api:location:6.1.0")

    //recyclerview
    //implementation("com.github.CymChad:BaseRecyclerViewAdapterHelper:2.9.50")

    //indexRecyclerview
    //implementation("me.yokeyword:indexablerecyclerview:1.3.0")
    //implementation("com.contrarywind:Android-PickerView:4.1.9")

    //刘海屏适配
    //implementation("com.github.KilleTom:BangScreenToolsMaster:v1.0.0")

    //图表库
    //implementation("com.openxu.viewlib:OXViewLib:1.0.2")
    //implementation("com.github.PhilJay:MPAndroidChart:v3.1.0")

    //日历库
    //implementation("com.necer.ncalendar:ncalendar:5.0.2")
    //环形视图
    //implementation("com.github.jakob-grabner:Circle-Progress-View:1.4")

    //app update
    const val appUpdate = "com.github.azhon:AppUpdate:4.0.0"
}

