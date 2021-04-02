package com.study.android.wan.ui.index.adapter

import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.study.android.wan.base.BaseBindingViewHolder
import com.study.android.wan.base.getViewHolder
import com.study.android.wan.databinding.ItemArticleBinding
import com.study.android.wan.ui.index.repo.IndexRepo
import com.study.android.wan.ui.index.vo.ArticleVo

/**
 * Description:
 * @author: xuyunlong
 * Date: 2021/3/31 18:18
 * @version 2.2
 */
class PageAdapter:PagingDataAdapter<ArticleVo,BaseBindingViewHolder<ItemArticleBinding>>(COMPARATOR) {
    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<ArticleVo>() {
            override fun areItemsTheSame(oldItem: ArticleVo, newItem: ArticleVo): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ArticleVo, newItem: ArticleVo): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: BaseBindingViewHolder<ItemArticleBinding>, position: Int) {
        holder.mBinding.data = getItem(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseBindingViewHolder<ItemArticleBinding> {
        return parent.getViewHolder(ItemArticleBinding::inflate)
    }
}