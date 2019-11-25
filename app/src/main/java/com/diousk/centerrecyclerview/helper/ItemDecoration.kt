package com.diousk.centerrecyclerview.helper

import android.content.res.Resources
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemDecoration (
    private val paddingPx: Int = dpToPx(12),
    private val viewWidthPx: Int = dpToPx(120)
): RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        val itemCount = parent.adapter?.itemCount ?: 0
        val startMargin = if (position == 0) {
            (screenWidth() - viewWidthPx)/2
        } else {
            paddingPx
        }
        val endMargin = if (position == itemCount - 1) {
            (screenWidth() - viewWidthPx)/2
        } else {
            paddingPx
        }
        outRect.set(startMargin, 0, endMargin, 0)
    }
}

fun screenWidth(): Int {
    return Resources.getSystem().displayMetrics.widthPixels
}

fun screenHeight(): Int {
    return Resources.getSystem().displayMetrics.heightPixels
}

fun dpToPx(dp: Int): Int {
    return (dp * Resources.getSystem().displayMetrics.density + 0.5f).toInt()
}