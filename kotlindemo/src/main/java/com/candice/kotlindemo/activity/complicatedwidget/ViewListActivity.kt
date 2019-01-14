package com.candice.kotlindemo.activity.complicatedwidget

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.candice.kotlindemo.R
import com.candice.kotlindemo.base.BaseActivity
import kotlinx.android.synthetic.main.activity_view_list.*
import org.jetbrains.anko.selector
import org.jetbrains.anko.toast

/**
 * <br>
 * <br>
 * @desc 视图排列
 * @author lei
 * @date 2019/1/4 下午3:14
 * @version ent_2.0
 * <br>
 * <br>
 */
class ViewListActivity : BaseActivity() {
    val array = arrayOf("金星", "木星", "水星", "火星", "土星")
    override fun getLayoutId(): Int {
        return R.layout.activity_view_list
    }

    override fun initAction() {
        tv_view_title.setOnClickListener {
            finish()
        }
    }

    override fun loadData() {
    }

    override fun initView() {
        //Spinner的普通用法
        normalSpinner()
        //ankoSpinner用法
        ankoSpinner();


    }

    private fun ankoSpinner() {
        val list = listOf("金星", "木星", "水星", "火星", "土星")
        with(tv_anko_spinner) {
            text = list[0]
            setOnClickListener {
                selector("请选择行星", list) { it ->
                    tv_anko_spinner.text = list[it]
                    toast("您选择的是：${list[it]}")
                }
            }
        }

    }

    private fun normalSpinner() {
        //Spinner的普通用法
        val adapter = ArrayAdapter<String>(this, R.layout.item_spinner, array)
//        adapter.setDropDownViewResource(R.layout.item_dropdown)
        spinner.prompt = "请选择行星"
        spinner.adapter = adapter
        spinner.setSelection(0)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                toast("选中的行星是：${array[position]}")
            }

        }
    }


    override fun initData() {

    }


    companion object {
        fun launch(context: Context) {
            val intent = Intent()
            intent.setClass(context, ViewListActivity::class.java)
            context.startActivity(intent)
        }
    }


}
