package com.zgs.library.demo

import android.os.Bundle
import com.zgs.library.demo.base.activity.BaseActivity
import com.zgs.library.demo.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun layoutId(): Int = R.layout.activity_main

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun initData() {
    }

}