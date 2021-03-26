package com.study.android.wan.ui.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.study.android.wan.R
import com.study.android.wan.base.BaseVMFragment
import com.study.android.wan.base.BaseViewModel
import com.study.android.wan.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SplashFragment : BaseVMFragment<FragmentSplashBinding>() {

    override fun getLayutRes(): Int =R.layout.fragment_splash

    override fun initView() {
        mBinding.button.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_splashFragment_to_homeFragment)
        }
    }

    override fun bindView(view: View, savedInstanceState: Bundle?): FragmentSplashBinding {
        return FragmentSplashBinding.bind(view)
    }

    override fun getViewModel(): BaseViewModel? {
        return null
    }
}