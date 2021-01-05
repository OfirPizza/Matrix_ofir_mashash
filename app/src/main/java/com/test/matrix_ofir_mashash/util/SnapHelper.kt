package com.test.matrix_ofir_mashash.util

import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView

class SnapHelper : LinearSnapHelper() {

    override fun findTargetSnapPosition(
        layoutManager: RecyclerView.LayoutManager,
        velocityX: Int,
        velocityY: Int
    ): Int {

        val centerView = findSnapView(layoutManager) ?: return RecyclerView.NO_POSITION
        val position = layoutManager.getPosition(centerView)
        var targetPosition = -1

        if (layoutManager.canScrollHorizontally()) {
            targetPosition = if (velocityX > 0) {
                position - 1
            } else {
                position + 1
            }
        }

        val firstItem = 0
        val lastItem = layoutManager.itemCount - 1
        targetPosition = lastItem.coerceAtMost(targetPosition.coerceAtLeast(firstItem))
        return targetPosition
    }
}