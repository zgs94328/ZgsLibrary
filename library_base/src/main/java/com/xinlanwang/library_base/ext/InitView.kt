package com.xinlanwang.library_base.ext

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * 作者　: zgs
 * 时间　: 2020/12/30
 * 描述　:
 */
fun RecyclerView.commonInit(
    bindAdapter: RecyclerView.Adapter<*>,
    orientation: Int = RecyclerView.VERTICAL,
    hasFixedSize: Boolean = true
): RecyclerView {
    layoutManager = LinearLayoutManager(context, orientation, false)
    setHasFixedSize(hasFixedSize)
    adapter = bindAdapter
    return this
}

fun RecyclerView.gridLayoutInit(
    bindAdapter: RecyclerView.Adapter<*>,
    column:Int,
    hasFixedSize: Boolean = true
): RecyclerView {
    layoutManager = GridLayoutManager(context,column )
    setHasFixedSize(hasFixedSize)
    adapter = bindAdapter
    return this
}
