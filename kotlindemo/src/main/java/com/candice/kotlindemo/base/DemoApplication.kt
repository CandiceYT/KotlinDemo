package com.candice.kotlindemo.base

import android.app.Application
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * <br>
 * function:
 * <p>
 * @author:Lyt
 * @date:2018/12/27 下午4:13
 * @since:V$VERSION
 * @desc:com.candice.kotlindemo.base
 */
class DemoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
    companion object {
        //使用延迟初始化
//        private lateinit var instance:DemoApplication
//        fun getInstance() = instance
        //使用系统自带的Delegates生成委托属性
//        private var instance: DemoApplication by Delegates.notNull()
//        fun instance() = instance

        //自定义一个非空且只能一次性赋值的委托属性
        private var instance: DemoApplication by NotNullSingleValue()
        fun instance() = instance
    }


    private class NotNullSingleValue :
        ReadWriteProperty<DemoApplication.Companion, DemoApplication> {
        private var value: DemoApplication? = null
        override fun getValue(thisRef: DemoApplication.Companion, property: KProperty<*>): DemoApplication {
            return value ?: throw IllegalStateException("application is not initialized")
        }

        override fun setValue(thisRef: DemoApplication.Companion, property: KProperty<*>, value: DemoApplication) {
            this.value = if (this.value == null) value
            else throw  IllegalStateException("application already initialized")
        }

    }

}



