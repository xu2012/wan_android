package com.study.android.wan.ui.knowledge

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.study.android.wan.R
import com.study.android.wan.base.BaseVMFragment
import com.study.android.wan.base.BaseViewModel
import com.study.android.wan.databinding.FragmentKnowledgeBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class KnowledgeFragment : BaseVMFragment<FragmentKnowledgeBinding>() {

    override fun getLayutRes(): Int = R.layout.fragment_knowledge

    override fun initView() {
    }

    override fun bindView(view: View, savedInstanceState: Bundle?): FragmentKnowledgeBinding {
        return FragmentKnowledgeBinding.bind(view)
    }

    override fun getViewModel(): BaseViewModel? = null
}