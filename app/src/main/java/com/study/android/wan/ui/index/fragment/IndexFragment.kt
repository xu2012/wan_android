package com.study.android.wan.ui.index.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.scwang.smartrefresh.layout.constant.RefreshState
import com.study.android.wan.R
import com.study.android.wan.base.BaseVMFragment
import com.study.android.wan.base.BaseViewModel
import com.study.android.wan.databinding.FragmentIndexBinding
import com.study.android.wan.ui.index.adapter.ArticleAdapter
import com.study.android.wan.ui.index.adapter.PageAdapter
import com.study.android.wan.ui.index.viewmodel.IndexViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 * Use the [IndexFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class IndexFragment : BaseVMFragment<FragmentIndexBinding>() {
    val viewModel: IndexViewModel by viewModels()
    override fun getLayutRes(): Int = R.layout.fragment_index
    private val pageAdapter = PageAdapter()
    override fun initView() {
        val adapter = ArticleAdapter()
        mBinding.apply {
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = pageAdapter
            swip.setOnRefreshListener {
                pageAdapter.refresh()
            }
            swip.setOnLoadMoreListener {
                pageAdapter.retry()
            }
        }
        viewModel.dataList.observe(this, Observer {
            adapter.setItem(it)
        })
        lifecycleScope.launch {
            viewModel.getPage().collect {
                pageAdapter.submitData(it)
            }
        }

        var hasRefreshing = false
        var hasLoadingMore = false
        pageAdapter.addLoadStateListener {
            when (it.refresh) {
                is LoadState.NotLoading -> {
                    if (hasRefreshing) {
                        hasRefreshing= false
                        mBinding.swip.finishRefresh(true)
                        //如果第一页数据就没有更多了，第一页不会触发append
                        if (it.source.append.endOfPaginationReached){
                            //没有更多了(只能用source的append)
                            mBinding.swip.finishLoadMoreWithNoMoreData()
                        }
                    }
                    Log.d("xu", "NotLoading")
                }
                is LoadState.Loading -> {
                    hasRefreshing = true
                    //如果是手动下拉刷新，则不展示loading页
                    if (mBinding.swip.state != RefreshState.Refreshing) {
//                        statePager.showLoading()
                    }
                    Log.d("xu", "Loading")
                }
                is LoadState.Error -> {
                    Log.d("xu", "Error")
                    mBinding.swip.finishLoadMore(false)

                }
            }
            when (it.append) {
                is LoadState.NotLoading -> {
                    if (hasLoadingMore) {
                        hasLoadingMore = false
                        if (it.source.append.endOfPaginationReached) {
                            //没有更多了(只能用source的append)
                            mBinding.swip.finishLoadMoreWithNoMoreData()
                        } else {
                            mBinding.swip.finishLoadMore(true)
                        }
                    }
                }
                is LoadState.Loading -> {
                    hasLoadingMore = true
                    //重置上拉加载状态，显示加载loading
                    mBinding.swip.resetNoMoreData()
                }
                is LoadState.Error -> {
                    mBinding.swip.finishLoadMore(false)
                }
            }
        }
    }

    override fun bindView(view: View, savedInstanceState: Bundle?): FragmentIndexBinding {
        return FragmentIndexBinding.bind(view)
    }

    override fun getViewModel(): BaseViewModel {
        return viewModel
    }
}