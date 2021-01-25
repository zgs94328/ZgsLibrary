package com.xinlanwang.library_base.util

import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.xinlanwang.library_base.base.BaseApplication

/**
 * 可在任意线程执行本类方法
 * User: ljx
 * Date: 2017/3/8
 * Time: 10:31
 */
object Toast {
    private val mHandler = Handler(Looper.getMainLooper())
    private var mToast: Toast? = null

    @JvmOverloads
    fun show(msgResId: Int, timeLong: Boolean = false) {
        show(
            BaseApplication.sInstance.getString(msgResId),
            timeLong
        )
    }

    @JvmOverloads
    fun show(msg: CharSequence?, timeLong: Boolean = false) {
        runOnUiThread(Runnable {
            if (mToast != null) {
                mToast!!.cancel()
            }
            val duration = if (timeLong) Toast.LENGTH_LONG else Toast.LENGTH_SHORT
            mToast =
                Toast.makeText(BaseApplication.sInstance, msg, duration)
            mToast?.show()
        })
    }

    private fun runOnUiThread(runnable: Runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run()
        } else {
            mHandler.post(runnable)
        }
    }
}