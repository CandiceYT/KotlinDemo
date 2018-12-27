package com.candice.kotlindemo.util

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.candice.kotlindemo.base.BaseActivity

/**
 * <br>
 * function:
 * <p>
 *     和view操作相关的工具类
 * @author:Lei
 * @date:2018/12/27 下午4:03
 * @since:V$VERSION
 * @desc:com.candice.kotlindemo.util
 */
/**
 * 显示软键盘
 */
fun showSoftKeybord(context: Context, view: View) {
    val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    view.requestFocus()
    inputMethodManager.showSoftInput(view, InputMethodManager.SHOW_FORCED)
}

/**
 * 隐藏软键盘
 */
fun hideSoftKeyBord(context: Context) {
    val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(
        (context as BaseActivity).currentFocus.windowToken,
        InputMethodManager.HIDE_NOT_ALWAYS
    )

}