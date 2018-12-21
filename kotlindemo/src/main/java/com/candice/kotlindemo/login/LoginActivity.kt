package com.candice.kotlindemo.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.candice.kotlindemo.R

class LoginActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_login)
	}




	companion object Launch{
		fun launch(context: Context){
			val intent = Intent()
			intent.setClass(context,LoginActivity::class.java)
			context.startActivity(intent)
		}
	}
}
