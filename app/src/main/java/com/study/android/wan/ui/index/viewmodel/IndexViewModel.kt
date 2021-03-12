package com.study.android.wan.ui.index.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.study.android.wan.base.BaseViewModel
import com.study.android.wan.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Description:
 * @author: xuyunlong
 * Date: 2021/3/12 14:29
 * @version 2.2
 */
@HiltViewModel
class IndexViewModel @Inject constructor(val apiService: ApiService):BaseViewModel() {
    fun test(){
        viewModelScope.launch {
            val homeArticle = apiService.getHomeArticle(1)
            Log.d("xu",homeArticle.data.toString())
        }
    }
}