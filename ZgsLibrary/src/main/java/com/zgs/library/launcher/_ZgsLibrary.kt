package com.zgs.library.launcher

import android.app.Application
import android.content.Context

/**
 * 作者　: zgs
 * 时间　: 2021/1/25
 * 描述　:
 */
object _ZgsLibrary {
    private var mContext: Context? = null
    private var debuggable = false
    fun init(application: Application?): Boolean {
        mContext = application

        return true
    }

    fun openDebug() {
        debuggable = true
    }
}