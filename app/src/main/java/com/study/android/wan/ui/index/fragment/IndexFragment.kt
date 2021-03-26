package com.study.android.wan.ui.index.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.study.android.wan.R
import com.study.android.wan.base.BaseVMFragment
import com.study.android.wan.base.BaseViewModel
import com.study.android.wan.databinding.FragmentIndexBinding
import com.study.android.wan.ui.index.adapter.ArticleAdapter
import com.study.android.wan.ui.index.viewmodel.IndexViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass.
 * Use the [IndexFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class IndexFragment : BaseVMFragment<FragmentIndexBinding>() {
    val viewModel: IndexViewModel by viewModels()
    override fun getLayutRes(): Int = R.layout.fragment_index

    override fun initView() {
        val adapter = ArticleAdapter()
        mBinding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        mBinding.recyclerView.adapter = adapter
        viewModel.dataList.observe(this, Observer {
            adapter.setItem(it)
        })
        viewModel.getArticles(1)
    }

    override fun bindView(view: View, savedInstanceState: Bundle?): FragmentIndexBinding {
        return FragmentIndexBinding.bind(view)
    }

    override fun getViewModel(): BaseViewModel {
        return viewModel
    }
}