package com.study.android.wan.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * Description:
 * @author: xuyunlong
 * Date: 2021/3/19 11:12
 * @version 2.2
 */
open class BaseBindingViewHolder<T : ViewBinding> private constructor(val mBinding: T) :
    RecyclerView.ViewHolder(mBinding.root) {
    //
    constructor(
        parent: ViewGroup,
        creator: (inflater: LayoutInflater, root: ViewGroup, attachToRoot: Boolean) -> T
    ) : this(creator(LayoutInflater.from(parent.context), parent, false))

}

fun <T : ViewBinding> ViewGroup.getViewHolder(
    creator: (inflater: LayoutInflater, root: ViewGroup, attachToRoot: Boolean) -> T
): BaseBindingViewHolder<T> = BaseBindingViewHolder(this, creator)