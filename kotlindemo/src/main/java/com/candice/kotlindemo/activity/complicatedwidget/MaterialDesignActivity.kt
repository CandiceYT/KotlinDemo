package com.candice.kotlindemo.activity.complicatedwidget

import android.content.Context
import android.content.Intent
import android.support.design.widget.Snackbar
import com.candice.kotlindemo.R
import com.candice.kotlindemo.base.BaseActivity
import kotlinx.android.synthetic.main.activity_material_design.*

class MaterialDesignActivity : BaseActivity() {

    companion object {
        fun launch(context: Context){
            val intent = Intent()
            intent.setClass(context, MaterialDesignActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_material_design
    }

    override fun initAction() {
        btn_snackbar.setOnClickListener {
            Snackbar.make(cl_root,"这是个提示条",Snackbar.LENGTH_LONG).show()
        }
    }

    override fun loadData() {
    }

    override fun initView() {
    }

    override fun initData() {
    }

}
