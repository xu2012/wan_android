package com.study.android.wan.web

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.just.agentweb.AgentWeb
import com.study.android.wan.R
import com.study.android.wan.base.BaseVMFragment
import com.study.android.wan.base.BaseViewModel
import com.study.android.wan.databinding.FragmentWebBinding
class WebFragment : BaseVMFragment<FragmentWebBinding>() {
    private lateinit var mAgentWeb:AgentWeb
    override fun getLayutRes(): Int = R.layout.fragment_web

    override fun initView() {
        mAgentWeb = AgentWeb.with(this)
            .setAgentWebParent(mBinding.frameLayout, LinearLayout.LayoutParams(-1,-1))
            .useDefaultIndicator()
            .createAgentWeb()
            .ready()
            .go("http://www.baidu.com")
    }

    override fun bindView(view: View, savedInstanceState: Bundle?): FragmentWebBinding {
        return FragmentWebBinding.bind(view)
    }

    override fun getViewModel(): BaseViewModel? = null
}