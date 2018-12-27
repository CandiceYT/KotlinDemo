package com.candice.kotlindemo

import android.util.Log

/**
 * <br>
 * function:
 * <p>
 * @author:Lei
 * @date:2018/12/25 上午9:59
 * @since:V$VERSION
 * @desc:com.candice.kotlindemo
 */
class Person @JvmOverloads constructor(var name: String) {
    lateinit var mAge: String

    init {
        Log.e("TAG","init")
    }

    @JvmOverloads
    constructor(name: String, age: String) : this(name) {
        mAge = age
        Log.e("TAG","从构造函数")
    }

    fun printLog(){
        Log.e("TAG","name is $name, age is $mAge")
    }
}