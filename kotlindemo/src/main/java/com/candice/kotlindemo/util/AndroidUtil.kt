package com.candice.kotlindemo.util

import android.content.Context

/**
 * <br>
 * function:
 * <p>
 *     和项目相关的工具类
 * @author:Lyt
 * @date:2018/12/27 下午4:13
 * @since:V$VERSION
 * @desc:com.candice.kotlindemo.util
 */

fun Float.dip2px(context: Context):Int{
    val scale = context.resources.displayMetrics.density
    return (this * scale + 0.5f).toInt()
}

fun Float.px2dip(context: Context):Int{
    val scale = context.resources.displayMetrics.density
    return (this / scale + 0.5f).toInt()
}

