package com.zgs.library.demo.base.fragment

import com.zgs.library.base.fragment.BaseDbLibFragment
import com.zgs.library.demo.databinding.FragmentMainBinding


/**
 * 作者　: zgs
 * 时间　: 2021/1/25
 * 描述　:
 */
abstract class BaseFragment : BaseDbLibFragment<FragmentMainBinding>() {
    override fun showLoading(message: String) {
    }

    override fun dismissLoading() {
    }
}