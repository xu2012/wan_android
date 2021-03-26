package com.study.android.wan.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * Description:ViewModel基类
 * @author: xuyunlong
 * Date: 2021/3/12 14:22
 * @version 2.2
 */
open class BaseViewModel : ViewModel() {
    private val jobs = mutableListOf<Job>()
    val toastLiveData = MutableLiveData<String>()
    val accountLiveData = MutableLiveData<Boolean>()
    val loadingLiveData = MutableLiveData<Boolean>()

    /**
     * 启动协程发起请求，并添加到job列表中
     * @param block [@kotlin.ExtensionFunctionType] SuspendFunction1<CoroutineScope, Unit> 具体
     * @param showLoading Boolean 是否展示加载框
     */
    fun launchRequest(block: suspend CoroutineScope.() -> Unit, showLoading: Boolean = true) {
        viewModelScope.launch {
            if (showLoading) {
                loadingLiveData.postValue(true)
            }
            block.invoke(this)
            if (showLoading) {
                loadingLiveData.postValue(false)
            }
        }.addTo(jobs)
    }

    override fun onCleared() {
        //取消所有任务
        jobs.forEach {
            it.cancel()
        }
        super.onCleared()
    }
}

private fun Job.addTo(list: MutableList<Job>) {
    list.add(this)
}