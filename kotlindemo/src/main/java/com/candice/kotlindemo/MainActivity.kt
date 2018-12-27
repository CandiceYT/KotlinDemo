package com.candice.kotlindemo

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.candice.kotlindemo.base.BaseActivity
import com.candice.kotlindemo.login.LoginActivity
import com.candice.kotlindemo.widget.LinearItemDecoration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
	private val tag ="MainActivity"
	override fun getLayoutId(): Int {
		return R.layout.activity_main
	}

	override fun initAction() {
	}

	override fun loadData() {
	}

	var data = mutableListOf<String>()


	private val max: Int = 6

	override fun initData() {
		Log.i(tag,"initData()")
		for (i in 0 .. max) {
			data.add("btn$i")
		}
	}


	override fun initView() {
		val layoutManager = object :LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false){
			override fun canScrollVertically(): Boolean {
				return super.canScrollVertically()
			}

			override fun canScrollHorizontally(): Boolean {
				return super.canScrollHorizontally()
			}
		}
		val itemDecoration = LinearItemDecoration(this@MainActivity, LinearLayoutManager.VERTICAL, R.drawable.divider_shape, true)
		rv_list.addItemDecoration(itemDecoration)
		rv_list.layoutManager = layoutManager
		val mAdapter = RVAdapter(this@MainActivity)
		rv_list.adapter = mAdapter
		mAdapter.setData(data)
	}
}

class RVAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

	private var mContext: Context

	init {
		mContext = context
	}

	override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
		val content = data[p1]
		if (p0 is RVViewHolder) {
			p0.tvItem.text = content
			p0.tvItem.setOnClickListener {
				when (p1) {
					0 -> LoginActivity.launch(mContext)
					1 -> Person("Alice","12").printLog()
					else -> Toast.makeText(mContext, "不做跳转", Toast.LENGTH_LONG).show()

				}

			}
		}
	}

	override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
		val view = LayoutInflater.from(mContext).inflate(R.layout.item_layout, p0, false)
		return RVViewHolder(view)
	}

	class RVViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
		public var tvItem: TextView = view!!.findViewById<TextView>(R.id.tv_item)
	}

	override fun getItemCount(): Int {
		return data.size
	}

	private lateinit var data: MutableList<String>

	fun setData(data: MutableList<String>) {
		this.data = data
		notifyDataSetChanged()
	}

}
