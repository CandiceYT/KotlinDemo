package com.candice.kotlindemo.base

import android.app.Application
import android.content.Context

/**
 * <br>
 * function:
 * <p>
 * @author:Lei
 * @date:2018/12/27 下午4:13
 * @since:V$VERSION
 * @desc:com.candice.kotlindemo.base
 */
class DemoApplication : Application() {

    private  lateinit var sInstance: Context


    override fun onCreate() {
        super.onCreate()
        sInstance = this
    }
}

