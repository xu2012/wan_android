package com.study.android.wan.network

import androidx.annotation.Keep

/**
 * Description:
 * @author: xuyunlong
 * Date: 2021/3/12 14:10
 * @version 2.2
 */
@Keep
data class PageResult<T>(
    val curPage: Int,
    val datas: List<T>,
    val offset: Int,
    val pageCount: Int,
    val over: Boolean,
    val size: Int,
    val total: Int
)
