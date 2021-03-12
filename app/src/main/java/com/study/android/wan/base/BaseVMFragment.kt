package com.study.android.wan.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/**
 * Description:fragment基类
 * @author: xuyunlong
 * Date: 2021/3/12 14:21
 * @version 2.2
 */
abstract class BaseVMFragment<FragBinding : ViewDataBinding> : Fragment() {
    lateinit var mBinding: FragBinding
    var isFragmentViewInit = false
    var lastView: View? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (lastView == null) {
            lastView = inflater.inflate(getLayutRes(), container, false)
        }
        return lastView
    }

    abstract fun getLayutRes(): Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (!isFragmentViewInit) {
            super.onViewCreated(view, savedInstanceState)
            mBinding = bindView(view, savedInstanceState)
            mBinding.lifecycleOwner = viewLifecycleOwner
            initView()
        }
    }

    abstract fun initView()

    abstract fun bindView(view: View, savedInstanceState: Bundle?): FragBinding
}