package com.study.android.wan.ui.index.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.study.android.wan.base.BaseRepo
import com.study.android.wan.network.ApiResult
import com.study.android.wan.network.ApiService
import com.study.android.wan.network.PageResult
import com.study.android.wan.ui.index.page.IndexPageSource
import com.study.android.wan.ui.index.vo.ArticleVo
import com.study.android.wan.ui.index.vo.BannerVo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Description:
 * @author: xuyunlong
 * Date: 2021/3/12 16:54
 * @version 2.2
 */
class IndexRepo @Inject constructor(private val apiService: ApiService) : BaseRepo() {
    suspend fun getBanners(): ApiResult<List<BannerVo>> {
        return safeCall {
            apiService.getBanners()
        }
    }

    suspend fun getArticles(page: Int): ApiResult<PageResult<ArticleVo>> {
        return safeCall {
            apiService.getHomeArticle(page)
        }
    }
    fun getPage(): Flow<PagingData<ArticleVo>> {
        return Pager(config = PagingConfig(10),pagingSourceFactory = {IndexPageSource(apiService)}).flow
    }
}