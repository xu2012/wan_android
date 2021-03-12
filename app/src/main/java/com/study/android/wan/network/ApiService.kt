package com.study.android.wan.network

import com.study.android.wan.ui.index.vo.ArticleVo
import com.study.android.wan.ui.index.vo.BannerVo
import com.study.android.wan.ui.index.vo.WebSiteVo
import com.study.android.wan.ui.knowledge.vo.KnowledgeVo
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Description:
 * @author: xuyunlong
 * Date: 2021/3/12 13:45
 * @version 2.2
 */
interface ApiService {
    @GET("article/list/{page}/json")
    suspend fun getHomeArticle(@Path("page") page: Int): ApiResult<PageResult<ArticleVo>>

    @GET("banner/json")
    suspend fun getBanners(): ApiResult<List<BannerVo>>

    @GET("friend/json")
    suspend fun getCommonWeb(): ApiResult<List<WebSiteVo>>

    @GET("top/json")
    suspend fun gettop(): ApiResult<List<ArticleVo>>

    @GET("tree/json")
    suspend fun getKnowledges(): ApiResult<List<KnowledgeVo>>

    /**
     * 知识体系下的文章
     * @param page Int 拼接在链接上，从0开始。
     * @param cid String 分类的id，上述二级目录的id
     * @return ApiResult<PageResult<ArticleVo>>
     */
    @GET("article/list/{page}}/json")
    suspend fun getKnowledgesArticles(
        @Path("page") page: Int,
        @Query("cid") cid: String
    ): ApiResult<PageResult<ArticleVo>>
}