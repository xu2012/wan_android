package com.study.android.wan.ui.index.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.study.android.wan.base.BaseViewModel
import com.study.android.wan.network.ApiService
import com.study.android.wan.ui.index.page.IndexPageSource
import com.study.android.wan.ui.index.repo.IndexRepo
import com.study.android.wan.ui.index.vo.ArticleVo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Description:
 * @author: xuyunlong
 * Date: 2021/3/12 14:29
 * @version 2.2
 */
@HiltViewModel
class IndexViewModel @Inject constructor(private val repo: IndexRepo) : BaseViewModel() {
    val dataList = MutableLiveData<List<ArticleVo>>()
    fun getArticles(page: Int = 1) {
        launchRequest({
            val articles = repo.getArticles(page)
            dataList.postValue(articles.data?.datas)
        })
    }
    fun getPage(): Flow<PagingData<ArticleVo>> {
        return repo.getPage()
    }

   /* fun getPage(){
        launchRequest({
            repo.getPage().collect {
                dataList.postValue(it)
            }
        })
    }*/
}