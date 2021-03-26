package com.study.android.wan.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.study.android.wan.R
import com.study.android.wan.base.BaseVMFragment
import com.study.android.wan.base.BaseViewModel
import com.study.android.wan.databinding.FragmentHomeBinding
import com.study.android.wan.ui.index.fragment.IndexFragment
import com.study.android.wan.ui.knowledge.KnowledgeFragment
import com.study.android.wan.ui.project.ProjectFragment
import com.study.android.wan.ui.pub.PubFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseVMFragment<FragmentHomeBinding>(),
    BottomNavigationView.OnNavigationItemSelectedListener {

    override fun getLayutRes(): Int = R.layout.fragment_home

    override fun initView() {
        mBinding.apply {
            val adapter = MainPageAdapter(
                childFragmentManager,
                arrayListOf(IndexFragment(), KnowledgeFragment(), PubFragment(), ProjectFragment())
            )
            viewPager.adapter = adapter
            navView.setOnNavigationItemSelectedListener(this@HomeFragment)
            viewPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    mBinding.navView.menu.getItem(position).isChecked = true
                }
            })
        }
    }

    override fun bindView(view: View, savedInstanceState: Bundle?): FragmentHomeBinding {
        return FragmentHomeBinding.bind(view)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        mBinding.viewPager.currentItem = item.itemId
        when (item.itemId) {
            R.id.navigation_index -> {
                mBinding.viewPager.currentItem = 0
            }
            R.id.navigation_knoledge -> {
                mBinding.viewPager.currentItem = 1
            }
            R.id.navigation_pub -> {
                mBinding.viewPager.currentItem = 2
            }
            R.id.navigation_project -> {
                mBinding.viewPager.currentItem = 3
            }
            else -> {
            }
        }
        return false
    }

    override fun getViewModel(): BaseViewModel? {
        return null
    }
}