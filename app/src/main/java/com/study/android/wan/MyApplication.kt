package com.study.android.wan

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Description:
 * @author: xuyunlong
 * Date: 2021/3/12 13:46
 * @version 2.2
 */
@HiltAndroidApp
class MyApplication:Application() {
    override fun onCreate() {
        super.onCreate()
    }
}