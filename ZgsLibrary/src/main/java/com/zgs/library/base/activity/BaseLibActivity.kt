package com.zgs.library.base.activity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.zgs.library.base.viewmodel.BaseViewModel


/**
 * 作者　: zgs
 * 时间　: 2020/12/10
 * 描述　:原始基类activity，只有最基础的方法
 */
abstract class BaseLibActivity: AppCompatActivity() {
    /**
     * 是否需要使用DataBinding 供子类BaseVmDbActivity修改，用户请慎动
     */
    private var isUserDb = false
    private val baseViewModel: BaseViewModel by viewModels()
    abstract fun layoutId(): Int
    abstract fun initView(savedInstanceState: Bundle?)
    abstract fun initData()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!isUserDb) {
            setContentView(layoutId())
        } else {
            initDataBind()
        }
        init(savedInstanceState)

    }

    private fun init(savedInstanceState: Bundle?) {
        initView(savedInstanceState)
        initData()
        registerUiChange()

    }
    /**
     * 供子类BaseVmDbActivity 初始化Databinding操作
     */
    open fun initDataBind() {}
    fun userDataBinding(isUserDb: Boolean) {
        this.isUserDb = isUserDb
    }
    abstract fun showLoading(message: String = "请求网络中...")

    abstract fun dismissLoading()
    /**
     * 注册UI 事件
     */
    private fun registerUiChange() {
        //显示弹窗
        baseViewModel.loadingChange.showDialog.observeInActivity(this, Observer {
            showLoading(it)
        })
        //关闭弹窗
        baseViewModel.loadingChange.dismissDialog.observeInActivity(this, Observer {
            dismissLoading()
        })
    }
}