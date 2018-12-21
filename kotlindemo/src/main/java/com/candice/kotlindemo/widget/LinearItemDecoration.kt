package com.candice.kotlindemo.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View

/**
 * <br>
 * function:
 * <p>
 * @author:Lei
 * @date:2018/12/20 下午3:43
 * @since:V$VERSION
 * @desc:com.candice.kotlindemo.widget
 */
class LinearItemDecoration @JvmOverloads constructor(context: Context, orientation: Int,  needBottomLine: Boolean = false) : RecyclerView.ItemDecoration() {
	private var mDivider: Drawable? = null
	private var mOrientation: Int = 0
	private var mDividerHeight = 2
	private var mNeedBottomLine = false

	companion object {
		//线性布局，布局的方向，垂直和水平
		val HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL
		val VERTICAL_LIST = LinearLayoutManager.VERTICAL
	}

	init {
		Log.i("TAG","LinearItemDecoration==init")
		val a = context.obtainStyledAttributes(intArrayOf(android.R.attr.listDivider))
		mDivider = a.getDrawable(0)
		a.recycle()

		setOrientation(orientation)
		setNeedBottomLine(needBottomLine)

	}

	@JvmOverloads constructor(context: Context, orientation: Int, drawableId: Int, needBottomLine: Boolean = false) : this(context, orientation, needBottomLine) {
		Log.i("TAG","LinearItemDecoration==从构造器")
		mDivider = context.getDrawable(drawableId)
		mDividerHeight = mDivider!!.intrinsicHeight

	}

	private fun setNeedBottomLine(needBottomLine: Boolean) {
		mNeedBottomLine = needBottomLine
	}

	private fun setOrientation(orientation: Int) {
		if (HORIZONTAL_LIST != orientation && VERTICAL_LIST != orientation) {
			throw  IllegalArgumentException("invalid orientation");
		}
		mOrientation = orientation
	}

	override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
		c.save()
		if (mOrientation == VERTICAL_LIST) {
			drawVertical(c, parent)
		} else {
			drawHorizontal(c, parent)
		}
	}

	/**
	 * 垂直
	 */
	private fun drawVertical(c: Canvas, parent: RecyclerView) {
		val left = parent.paddingLeft
		val right = parent.width - parent.paddingRight
		val childCount = parent.childCount
		val count = if (mNeedBottomLine) childCount else childCount - 1
		for (i in 0 until  count) {
			val child = parent.getChildAt(i)
			val layoutParams = child.layoutParams as RecyclerView.LayoutParams
			val top = child.bottom + layoutParams.bottomMargin
			val bottom = top + mDividerHeight
			if (mDivider != null) {
				mDivider!!.setBounds(left,top, right, bottom)
				mDivider!!.draw(c)
			}
		}
	}

	/**
	 * 线性
	 */
	private fun drawHorizontal(c: Canvas, parent: RecyclerView) {
		val top = parent.paddingTop
		val bottom = parent.height - parent.paddingBottom
		val childCount = parent.childCount
		for (i in 0 until childCount) {
			val child = parent.getChildAt(i)
			val layoutParams: RecyclerView.LayoutParams = child.layoutParams as RecyclerView.LayoutParams
			val left = child.left + layoutParams.rightMargin
			val right = left + mDividerHeight
			if (mDivider != null) {
				mDivider!!.setBounds(left, top, right, bottom)
				mDivider!!.draw(c)
			}
		}
	}

	override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
		if (mOrientation == VERTICAL_LIST) {
			outRect.set(0, 0, 0, mDividerHeight);
		} else {
			outRect.set(0, 0, mDividerHeight, 0);
		}
	}


}