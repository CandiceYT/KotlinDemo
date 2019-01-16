package com.candice.kotlindemo.bean

/**
 * <br>
 * function:
 * <p>
 * @author:Lei
 * @date:2019/1/16 下午3:45
 * @since:
 * @desc:com.candice.kotlindemo.bean
 */
data class StarBean(
    var message: String,
    var starList: List<Star>,
    var status: String
)

data class Star(
    var starDesc: String,
    var starImg: String,
    var starName: String
)