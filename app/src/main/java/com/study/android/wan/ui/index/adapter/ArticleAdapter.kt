package com.study.android.wan.ui.index.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.study.android.wan.base.BaseBindingViewHolder
import com.study.android.wan.base.getViewHolder
import com.study.android.wan.databinding.ItemArticleBinding
import com.study.android.wan.ui.index.vo.ArticleVo

/**
 * Description:
 * @author: xuyunlong
 * Date: 2021/3/19 11:00
 * @version 2.2
 */
class ArticleAdapter : RecyclerView.Adapter<BaseBindingViewHolder<ItemArticleBinding>>() {
    private var list: List<ArticleVo> = listOf()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseBindingViewHolder<ItemArticleBinding> {
        return parent.getViewHolder(ItemArticleBinding::inflate)
    }

    override fun onBindViewHolder(
        holder: BaseBindingViewHolder<ItemArticleBinding>,
        position: Int
    ) {
        holder.mBinding.data = list[position]
    }

    override fun getItemCount(): Int = list.size
    fun setItem(list: List<ArticleVo>) {
        this.list = list
        notifyDataSetChanged()
    }

}