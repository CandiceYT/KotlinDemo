package com.candice.kotlindemo.activity.complicatedwidget

import android.content.Context
import android.content.Intent
import android.os.Environment
import android.text.TextUtils
import com.candice.kotlindemo.R
import com.candice.kotlindemo.base.BaseActivity
import kotlinx.android.synthetic.main.activity_storage.*
import org.jetbrains.anko.toast
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

/**
 * @desc: 存储
 * @author lyt
 * @date 2019/1/24 上午10:52
 * @version
 * <br>
 * <br>
 */
class StorageActivity : BaseActivity() {
    private lateinit var dir: String
    private lateinit var currentTime: String
    override fun getLayoutId(): Int {
        return R.layout.activity_storage
    }

    companion object {
        fun launch(context: Context) {
            val intent = Intent()
            intent.setClass(context, StorageActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun initAction() {
        val path = "$dir/$currentTime.text"
        //保存
        btn_save.setOnClickListener {
            //保存文本
            val content = input.text.toString()
            if (TextUtils.isEmpty(content)) {
                toast("输入的内容不能为空")
            } else {
                File(path).writeText(content)
                toast("保存成功")
            }

        }
        //读取
        btn_read.setOnClickListener {
            val readText = File(path).readText()
            tv_read.text = "path：$path;保存的信息是：$readText"
        }
    }

    override fun loadData() {

    }

    override fun initView() {


    }

    override fun initData() {
        dir = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).toString()
        val dateFormat = SimpleDateFormat("yyyyMMdd HH:mm:ss")
        currentTime = dateFormat.format(Date())
    }


}
