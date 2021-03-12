package com.study.android.wan.ui.index.vo

import androidx.annotation.Keep

/**
 * Description:
 * @author: xuyunlong
 * Date: 2021/3/12 17:07
 * @version 2.2
 */
@Keep
data class BannerVo(
    val desc: String,
    val id: Int,
    val imagePath: String,
    val isVisible: Int,
    val order: Int,
    val title: String,
    val type: Int,
    val url: String
)