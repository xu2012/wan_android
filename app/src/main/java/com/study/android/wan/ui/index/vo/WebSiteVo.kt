package com.study.android.wan.ui.index.vo

import androidx.annotation.Keep

/**
 * Description:
 * @author: xuyunlong
 * Date: 2021/3/12 17:10
 * @version 2.2
 */
@Keep
data class WebSiteVo(
    val category: String,
    val icon: String,
    val id: Int,
    val link: String,
    val name: String,
    val order: Int,
    val visible: Int
)