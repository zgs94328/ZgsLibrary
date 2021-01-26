package com.zgs.library.base.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import com.zgs.library.base.viewmodel.BaseViewModel


/**
 * 作者　: zgs
 * 时间　: 2020/12/8
 * 描述　:
 */
abstract class BaseLibFragment: Fragment() {
    private val baseViewModel: BaseViewModel by viewModels()
    //是否第一次加载
    var isFirst: Boolean = true
    lateinit var mActivity: AppCompatActivity
    /**
     * 当前Fragment绑定的视图布局
     */
    abstract fun layoutId(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId(), container, false)
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as AppCompatActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isFirst = true
        initView(savedInstanceState)
        initData()
        registorDefUIChange()
        createObserver()
    }



    /**
     * 初始化view
     */
    abstract fun initView(savedInstanceState: Bundle?)

    /**
     * 懒加载
     */
    abstract fun lazyLoadData()

    /**
     * 创建观察者
     */
    abstract fun createObserver()

    override fun onResume() {
        super.onResume()
        onVisible()
    }

    /**
     * 是否需要懒加载
     */
    private fun onVisible() {
        if (lifecycle.currentState == Lifecycle.State.STARTED && isFirst) {
            //等待view加载后触发懒加载
            view?.post {
                lazyLoadData()
                isFirst = false
            }
        }
    }

    /**
     * Fragment执行onCreate后触发的方法
     */
    open fun initData() {}

    abstract fun showLoading(message: String = "请求网络中...")

    abstract fun dismissLoading()
    /**
     * 注册 UI 事件
     */
    private fun registorDefUIChange() {
        baseViewModel.loadingChange.showDialog.observeInFragment(this, Observer {
            showLoading(it)
        })
        baseViewModel.loadingChange.dismissDialog.observeInFragment(this, Observer {
            dismissLoading()
        })
    }

}