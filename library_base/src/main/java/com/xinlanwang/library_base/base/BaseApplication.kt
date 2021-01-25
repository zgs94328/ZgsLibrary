package com.xinlanwang.library_base.base

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import com.tencent.smtt.export.external.TbsCoreSettings
import com.tencent.smtt.sdk.QbSdk

/**
 * 作者　: zgs
 * 时间　: 2020/12/9
 * 描述　:
 */
open class BaseApplication: Application(), ViewModelStoreOwner {
    companion object {
        lateinit var sInstance: BaseApplication
    }

    override fun onCreate() {
        super.onCreate()
        setApplication(this)
        mAppViewModelStore = ViewModelStore()
        initSdk()
    }

    private fun initSdk() {
        // 在调用TBS初始化、创建WebView之前进行如下配置
        var map:HashMap<String, Any> = HashMap()
        map[TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER] = true;
        map[TbsCoreSettings.TBS_SETTINGS_USE_DEXLOADER_SERVICE] = true;
        QbSdk.initTbsSettings(map);
    }

    private lateinit var mAppViewModelStore: ViewModelStore

    private var mFactory: ViewModelProvider.Factory? = null

    override fun getViewModelStore(): ViewModelStore {
        return mAppViewModelStore
    }


    /**
     * 获取一个全局的ViewModel
     */
    fun getAppViewModelProvider(): ViewModelProvider {
        return ViewModelProvider(this, this.getAppFactory())
    }

    private fun getAppFactory(): ViewModelProvider.Factory {
        if (mFactory == null) {
            mFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(this)
        }
        return mFactory as ViewModelProvider.Factory
    }


    /** 当宿主没有继承自该Application时,可以使用set方法进行初始化baseApplication  */
    open fun setApplication(application: BaseApplication) {
        sInstance = application
        application
            .registerActivityLifecycleCallbacks(object :
                ActivityLifecycleCallbacks {
                override fun onActivityCreated(
                    activity: Activity,
                    savedInstanceState: Bundle?
                ) {
                    AppManager.getInstance().addActivity(activity)
                }

                override fun onActivityStarted(activity: Activity) {}
                override fun onActivityResumed(activity: Activity) {}
                override fun onActivityPaused(activity: Activity) {}
                override fun onActivityStopped(activity: Activity) {}
                override fun onActivitySaveInstanceState(
                    activity: Activity, outState: Bundle
                ) {
                }

                override fun onActivityDestroyed(activity: Activity) {
                    AppManager.getInstance().removeActivity(activity)
                }
            })
    }

    /**
     * 获得当前app运行的Application
     */
    open fun getInstance(): BaseApplication? {
        if (BaseApplication.sInstance == null) {
            throw NullPointerException(
                "please inherit BaseApplication or call setApplication."
            )
        }
        return BaseApplication.sInstance
    }



}
