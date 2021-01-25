package com.xinlanwang.library_base.ext.util

import android.content.Context
import android.view.View
import android.widget.TextView


/**
 * 作者　: zgs
 * 时间　: 2020/12/28
 * 描述　:
 */

/**
 * 获取屏幕宽度
 */
val Context.screenWidth
    get() = resources.displayMetrics.widthPixels

/**
 * 获取屏幕高度
 */
val Context.screenHeight
    get() = resources.displayMetrics.heightPixels

/**
 * dp值转换为px
 */
fun Context.dp2px(dp: Int): Float {
    val scale = resources.displayMetrics.density
    return (dp * scale + 0.5f)
}

/**
 * px值转换成dp
 */
fun Context.px2dp(px: Int): Float {
    val scale = resources.displayMetrics.density
    return (px / scale + 0.5f)
}

/**
 * dp值转换为px
 */
fun View.dp2px(dp: Int): Float {
    val scale = resources.displayMetrics.density
    return (dp * scale + 0.5f)
}

/**
 * px值转换成dp
 */
fun View.px2dp(px: Int): Float {
    val scale = resources.displayMetrics.density
    return (px / scale + 0.5f)
}

/**
 * 获取textview一行最大能显示几个字(需要在TextView测量完成之后)
 *
 * @param text     文本内容
 */
fun TextView.getLineMaxNumber(text: String?, maxWidt:Int ): Int {

    if (null == text || "" == text) {
        return 0
    }
    //得到文本内容总体长度
    //得到文本内容总体长度
    val textWidth = paint.measureText(text)
    // textWidth
    // textWidth
    val width: Float = textWidth / text.length
    return (maxWidt / width).toInt()

}
