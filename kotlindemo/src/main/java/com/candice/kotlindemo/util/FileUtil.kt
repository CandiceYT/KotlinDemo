package com.candice.kotlindemo.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable
import android.text.TextUtils
import java.io.BufferedReader
import java.io.File
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

/**
 * 保存图片
 *
 * @author lyt
 * @date   2019/1/24 下午4:19
 * @return
 * @since
 */
fun String.saveImage(bitmap: Bitmap) {
    val file = File(this)
    val outputStream = file.outputStream()
    bitmap.compress(Bitmap.CompressFormat.JPEG, 80, outputStream)
    outputStream.flush()
    outputStream.close()
}

/**
 *  drawable转为Bitmap
 * @author lei
 * @date   2019/1/24 下午4:20
 * @return
 * @since
 */
fun Drawable.drawableToBitmap(): Bitmap {
    val height = this.intrinsicHeight
    val width = this.intrinsicWidth
    val opacity = this.opacity
    val config: Bitmap.Config = if (opacity != PixelFormat.OPAQUE) {
        Bitmap.Config.ARGB_8888
    } else {
        Bitmap.Config.RGB_565
    }
    val bitmap = Bitmap.createBitmap(width, height, config)
    val canvas = Canvas(bitmap)
    this.setBounds(0, 0, width, height)
    this.draw(canvas)
    return bitmap
}

/**
 * 利用字节数组读取位图
 * @author lyt
 * @date   2019/1/24 下午4:33
 * @return
 * @since
 */
fun String.readImgByBytes():Bitmap{
    val bytes = File(this).readBytes()
    return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
}

/**
 * 利用输入流读取
 * @author lyt
 * @date   2019/1/24 下午4:35
 * @return
 * @since
 */
fun String.readImgByStream():Bitmap{
    val fis = File(this).inputStream()
    val bitmap = BitmapFactory.decodeStream(fis)
    fis.close()
    return bitmap
}

/**
 * 利用文件读取
 * @author lyt
 * @date   2019/1/24 下午4:36
 * @return
 * @since
 */
fun String.readImgByFile():Bitmap{
    return BitmapFactory.decodeFile(this)
}



