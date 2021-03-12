package com.study.android.wan.network

import androidx.annotation.Keep

/**
 * Description:
 * @author: xuyunlong
 * Date: 2021/3/12 14:04
 * @version 2.2
 */
@Keep
data class ApiResult<T>(
    val data: T?,
    val errorCode: Int,
    val errorMsg: String?
    )