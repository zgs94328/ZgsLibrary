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
abstract class BaseDbLibActivity<DB : ViewDataBinding>: BaseLibActivity() {

    lateinit var mDatabind: DB

    override fun onCreate(savedInstanceState: Bundle?) {
        userDataBinding(true)
        super.onCreate(savedInstanceState)
    }

    /**
     * 创建DataBinding
     */
    override fun initDataBind() {
        mDatabind = DataBindingUtil.setContentView(this, layoutId())
        mDatabind.lifecycleOwner = this
    }
}