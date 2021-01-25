package com.xinlanwang.library_base.util.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * 作者　: zgs
 * 时间　: 2021/1/7
 * 描述　: gridlayoutmanager均分
 */
class GridSpaceItemDecoration(var spanCount: Int, var rowSpacing: Int, var columnSpacing: Int) :
    RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        var position = parent.getChildAdapterPosition(view);//获取view的位置
        var column = position % spanCount //所在的列
        var itemCount = state.itemCount;//item个数

        outRect.top = rowSpacing; // item top
        if (position >= spanCount||position==itemCount-1) {
            outRect.bottom = rowSpacing; // item bottom
        }

    }
}