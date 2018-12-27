package com.candice.kotlindemo.login

import android.content.Context
import android.content.Intent
import android.view.View
import com.candice.kotlindemo.R
import com.candice.kotlindemo.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {
	override fun getLayoutId(): Int {
		return R.layout.activity_login
	}

	override fun initAction() {

		btn_forget_password.setOnClickListener { }
	}

	override fun loadData() {
	}

	override fun initView() {
		et_phone_num.focusable = View.FOCUSABLE

	}

	override fun initData() {
	}


	override fun onRestart() {
		//自动清空密码框
		et_login_password.setText("")
		super.onRestart()
	}






	companion object Launch{
		fun launch(context: Context){
			val intent = Intent()
			intent.setClass(context,LoginActivity::class.java)
			context.startActivity(intent)
		}
	}
}
