package com.maxmesh.maxtask6.ui.fragments

import android.graphics.Rect
import androidx.recyclerview.widget.RecyclerView

class MarginItemDecoration : RecyclerView.ItemDecoration() {
    @Deprecated(
        "Deprecated in Java", ReplaceWith(
            "super.getItemOffsets(outRect, itemPosition, parent)",
            "androidx.recyclerview.widget.RecyclerView.ItemDecoration"
        )
    )
    override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView) {
        super.getItemOffsets(outRect, itemPosition, parent)
        outRect.bottom = 16
        outRect.top = 16
        outRect.left = 16
        outRect.right = 16
    }
}