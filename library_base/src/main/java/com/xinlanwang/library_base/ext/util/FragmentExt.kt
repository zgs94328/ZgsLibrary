package com.xinlanwang.library_base.ext.util

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

/**
 * 作者　: zgs
 * 时间　: 2020/12/28
 * 描述　:
 */
/**
 *加载fragment
 */
inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}
fun FragmentActivity.addFragment(fragment: Fragment, frameId: Int){
    supportFragmentManager.inTransaction { add(frameId, fragment) }
}

fun FragmentActivity.addFragment(fragment: Fragment, frameId: Int, bundle: Bundle? =null){
    supportFragmentManager.inTransaction { add(frameId, fragment) }
}


fun FragmentActivity.replaceFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction{replace(frameId, fragment)}
}