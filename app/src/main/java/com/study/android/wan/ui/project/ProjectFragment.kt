package com.study.android.wan.ui.project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.study.android.wan.R
import com.study.android.wan.base.BaseVMFragment
import com.study.android.wan.base.BaseViewModel
import com.study.android.wan.databinding.FragmentProjectBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProjectFragment : BaseVMFragment<FragmentProjectBinding>() {

    override fun getLayutRes(): Int = R.layout.fragment_project

    override fun initView() {
    }

    override fun bindView(view: View, savedInstanceState: Bundle?): FragmentProjectBinding {
        return FragmentProjectBinding.bind(view)
    }

    override fun getViewModel(): BaseViewModel? = null
}