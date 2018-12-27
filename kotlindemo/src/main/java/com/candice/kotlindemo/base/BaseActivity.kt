package com.candice.kotlindemo.base

import android.os.Bundle
import android.support.v4.app.FragmentActivity

/**
 * <br>
 * function:
 * <p>
 * @author:Lei
 * @date:2018/12/26 上午11:28
 * @since:V$VERSION
 * @desc:com.candice.kotlindemo
 */
open abstract class BaseActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initData()
        initView()
        loadData()
        initAction()
    }

    open abstract fun getLayoutId(): Int

    open abstract fun initAction()

    open abstract fun loadData()

    open abstract fun initView()

    open abstract fun initData()


    override fun onResume() {
        super.onResume()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}