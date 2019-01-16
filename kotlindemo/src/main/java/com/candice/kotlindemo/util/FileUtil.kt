package com.candice.kotlindemo.util

import android.content.Context
import android.text.TextUtils
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * <br>
 * function:
 * 操作文件的工具类
 * <p>
 * @author:Lei
 * @date:2019/1/16 上午9:56
 * @since:
 * @desc:com.candice.kotlindemo.util
 */

/**
 *  从assets目录下读取文件
 *
 * @author lei
 * @date   2019/1/16 上午10:08
 * @return
 * @since
 */
fun String.getDataFromAssets(context: Context): String {
    val buffer = StringBuffer()
    val inputStream = context.assets.open(this)
    val bufferedReader = BufferedReader(InputStreamReader(inputStream))
    var line: String?
    do {
        line = bufferedReader.readLine()
        if (!TextUtils.isEmpty(line)) {
            buffer.append(line)
        } else {
            break
        }
    } while (true)

    return (buffer.toString())!!

}