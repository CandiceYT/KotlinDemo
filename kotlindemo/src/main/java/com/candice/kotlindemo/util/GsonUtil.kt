package com.candice.kotlindemo.util

import com.google.gson.Gson

/**
 * <br>
 * function:
 * 操作Json的工具类
 * <p>
 * @author:Lei
 * @date:2019/1/16 下午3:32
 * @since:
 * @desc:com.candice.kotlindemo.util
 */
object GsonUtil {
    private const val TAG:String = "GsonUtil"
    private var mGson: Gson = Gson()

    /**
     * Json转成Bean
     * @author lei
     * @date   2019/1/16 下午3:41
     * @return
     * @since
     */
    fun <T> jsonToBean(json:String,cls: Class<T>): T {
        var result: T? = null
        try {
            result = mGson.fromJson(json, cls)
        } catch (e: Exception) {
            LogUtils.eTag(TAG, e.message)
        }

        return result!!
    }

}