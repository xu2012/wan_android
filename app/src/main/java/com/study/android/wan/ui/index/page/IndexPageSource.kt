package com.study.android.wan.ui.index.page

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.study.android.wan.network.ApiService
import com.study.android.wan.ui.index.repo.IndexRepo
import com.study.android.wan.ui.index.vo.ArticleVo
import java.lang.Exception
import javax.inject.Inject

/**
 * Description:
 * @author: xuyunlong
 * Date: 2021/3/31 17:56
 * @version 2.2
 */
class IndexPageSource  constructor(private val apiService: ApiService) :
    PagingSource<Int, ArticleVo>() {
    override fun getRefreshKey(state: PagingState<Int, ArticleVo>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ArticleVo> {
        return try {
            val page = params.key?:1
            Log.d("xu","page====$page")
            val articles = apiService.getHomeArticle(page)
            val repoItems = articles.data!!.datas
            val prevKey = if (page > 1) page - 1 else null
            val nextKey = if (repoItems.isNotEmpty()) page + 1 else null
            LoadResult.Page(repoItems,prevKey,nextKey)
        }catch (e:Exception){
            LoadResult.Error(e)
        }
    }
}