package com.zgs.library.demo.base.activity

import androidx.databinding.ViewDataBinding
import com.zgs.library.base.activity.BaseDbLibActivity

/**
 * 作者　: zgs
 * 时间　: 2021/1/25
 * 描述　: 你项目中的Activity基类，在这里实现显示弹窗，吐司，还有加入自己的需求操作 ，如果不想用Databind，请继承
 * BaseLibActivity
 */
abstract class BaseActivity<DB : ViewDataBinding> :BaseDbLibActivity<DB>(){
    override fun showLoading(message: String) {
    }

    override fun dismissLoading() {
    }
}