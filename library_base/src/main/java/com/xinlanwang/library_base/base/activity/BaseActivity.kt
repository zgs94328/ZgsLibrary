package com.xinlanwang.library_base.base.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter

/**
 * 作者　: zgs
 * 时间　: 2020/12/10
 * 描述　:原始基类activity，只有最基础的方法
 */
abstract class BaseActivity(var isDataBinding : Boolean = false): AppCompatActivity() {
    abstract fun layoutId(): Int
    /**
     * 供子类BaseVmDbActivity 初始化Databinding操作
     */
    open fun initDataBind() {}
    abstract fun initView(savedInstanceState: Bundle?)
    abstract fun initData()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(isDataBinding){
            initDataBind()
        }else{
            setContentView(layoutId())
        }
        ARouter.getInstance().inject(this)
        init(savedInstanceState)

    }
    private fun init(savedInstanceState: Bundle?) {
        initView(savedInstanceState)
        initData()
        createObserver()


    }

    /**
     * 创建LiveData数据观察者
     */
    abstract fun createObserver()

}