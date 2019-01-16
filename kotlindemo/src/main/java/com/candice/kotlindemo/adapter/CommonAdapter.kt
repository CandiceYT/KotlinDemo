package com.candice.kotlindemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.candice.kotlindemo.R
import com.candice.kotlindemo.bean.Star

/**
 * <br>
 * function:
 * ListView适配器
 * GridView适配器
 * <p>
 * @author:Lei
 * @date:2019/1/16 下午2:33
 * @since:
 * @desc:com.candice.kotlindemo.adapter
 */
class CommonAdapter(val context: Context) : BaseAdapter() {
    private var data: List<Star>?=null
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        val holder: ViewHolder
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_star, null, false)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            holder = (view!!.tag) as ViewHolder
        }

        val star = data!![position]
        holder.tvStarName.text = star.starName
        holder.tvStarDesc.text = star.starDesc
        return view!!
    }

    override fun getItem(position: Int): Any {
        return data!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        if (data == null || data!!.isEmpty()) {
            return 0
        }
        return data!!.size
    }


    fun setData(starList: List<Star>) {
        data = starList
        notifyDataSetChanged()
    }


    inner class ViewHolder(view: View) {
        val ivIcon = view.findViewById<ImageView>(R.id.iv_icon)!!
        val tvStarName = view.findViewById<TextView>(R.id.tv_star_name)!!
        val tvStarDesc = view.findViewById<TextView>(R.id.tv_star_desc)!!

    }
}