package com.candice.kotlindemo

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.candice.kotlindemo.login.LoginActivity
import com.candice.kotlindemo.widget.LinearItemDecoration
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.longToast

class MainActivity : AppCompatActivity() {

	var data = mutableListOf<String>()
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		initData()
		longToast("data的大小${data.size}")
		Log.i("TAG", "data的大小${data.size}")
		initView()
	}

	private val max: Int = 6

	private fun initData() {
		for (i in 0 .. max) {
			data.add("btn$i")
		}
	}


	private fun initView() {
		val layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)

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
