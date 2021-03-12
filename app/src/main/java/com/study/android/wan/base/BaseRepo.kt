package com.study.android.wan.base

import android.util.Log
import com.study.android.wan.network.ApiResult
import java.lang.Exception
import java.net.ConnectException

/**
 * Description:
 * @author: xuyunlong
 * Date: 2021/3/12 14:23
 * @version 2.2
 */
open class BaseRepo {
    companion object {
        const val TAG = "BaseRepo"
    }

    /**
     * 异步任务
     * @param action SuspendFunction0<ApiResult<T>>
     * @return ApiResult<T>
     */
    suspend fun <T> safeCall(action: suspend () -> ApiResult<T>): ApiResult<T> {
        return try {
            action.invoke()
        } catch (e: Exception) {
            e.localizedMessage?.let {
                Log.e(TAG, it)
            }
            convert(e)
        }
    }

    private fun <T> convert(e: Exception): ApiResult<T> {
        val message = when (e) {
            is ConnectException -> {
                "connection error"
            }
            else -> {
                "error"
            }
        }
        return ApiResult(null, -1, message)
    }
}