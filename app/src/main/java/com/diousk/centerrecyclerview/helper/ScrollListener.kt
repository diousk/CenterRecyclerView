package com.diousk.centerrecyclerview.helper

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper

class ScrollListener(
    private val snapHelper: SnapHelper,
    private val callback: Callback
): RecyclerView.OnScrollListener() {
    interface Callback {
        fun onPositionChanged(position: Int)
    }
    private var snapPosition = RecyclerView.NO_POSITION

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        dispatchPositionChange(recyclerView)
    }

    private fun dispatchPositionChange(recyclerView: RecyclerView) {
        val layoutManager = recyclerView.layoutManager ?: return
        val snapView = snapHelper.findSnapView(layoutManager) ?: return
        val snapPosition = layoutManager.getPosition(snapView)
        val snapPositionChanged = this.snapPosition != snapPosition
        if (snapPositionChanged) {
            callback.onPositionChanged(snapPosition)
            this.snapPosition = snapPosition
        }
    }
}