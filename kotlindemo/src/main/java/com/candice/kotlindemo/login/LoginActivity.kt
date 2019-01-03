package com.candice.kotlindemo.login

import android.content.Context
import android.content.Intent
import android.view.View
import com.candice.kotlindemo.R
import com.candice.kotlindemo.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.toast

class LoginActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    //是否是忘记密码
    private var isForgetPassword = true

    override fun initAction() {
        rg_group.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.rbtn_password_login -> updataUI("登录密码：", "忘记密码", "请输入密码", true)
                R.id.rbtn_check_code_login -> updataUI("    验证码：", "获取验证码", "请输入验证码", false)
                else -> updataUI("登录密码：", "忘记密码", "请输入密码", true)
            }
        }
        btn_forget_password.setOnClickListener {
            if (isForgetPassword) {
                //忘记密码
                btn_forget_password.text = "获取验证码"
                tv_phone_num.text = "输入新密码："
                et_phone_num.hint = "请输入新密码"
                tv_commit_password.visibility = View.VISIBLE
                et_commit_password.visibility = View.VISIBLE
                tv_login_password.text = "        验证码："
                rg_group.visibility = View.GONE
                ck_box.visibility = View.GONE
                btn_login.text = "确定"
                btn_forget_password.setOnClickListener {
                    alert("本次验证码是457346，请输入验证码","提示"){
                        positiveButton("好的"){
                            dismiss()
                        }
                    }.show()
                }

            } else {
                //点击获取验证码
                toast("获取验证码")
                alert("本次验证码是457346，请输入验证码","提示"){
                   positiveButton("好的"){
                       dismiss()
                   }
                }.show()
            }

        }


        btn_login.setOnClickListener {
            if (isForgetPassword){
                toast("确定")
                alert("修改密码成功","提示"){
                    positiveButton("好的"){
                        dismiss()
                    }
                }.show()
            }else{
                toast("登录")
                alert("登录成功","提示"){
                    positiveButton("好的"){
                        dismiss()
                    }
                }.show()
            }
        }
    }


    private fun updataUI(s: String, s1: String, hint: String, isForgetPassword: Boolean) {
        tv_login_password.text = s
        btn_forget_password.text = s1
        et_login_password.hint = hint
        this@LoginActivity.isForgetPassword = isForgetPassword
        if (!isForgetPassword){
            ck_box.visibility = View.GONE
        }


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


    companion object Launch {
        fun launch(context: Context) {
            val intent = Intent()
            intent.setClass(context, LoginActivity::class.java)
            context.startActivity(intent)
        }
    }
}
