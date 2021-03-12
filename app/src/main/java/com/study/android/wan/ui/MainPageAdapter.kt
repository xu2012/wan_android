package com.study.android.wan.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

/**
 * Description:
 * @author: xuyunlong
 * Date: 2020/12/17 18:16
 * @version 2.2
 */
class MainPageAdapter(fm:FragmentManager,private  val fragments:List<Fragment>):FragmentStatePagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {
        return  fragments[position]
    }

    override fun getCount(): Int {
        return  fragments.size
    }
}