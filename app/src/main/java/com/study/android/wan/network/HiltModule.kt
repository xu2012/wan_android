package com.study.android.wan.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.study.android.wan.network.annotation.ApiRetrofit
import com.study.android.wan.network.annotation.ApiUrl
import com.study.android.wan.network.annotation.OtherRetrofit
import com.study.android.wan.network.annotation.OtherUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Description:
 * @author: xuyunlong
 * Date: 2021/3/12 13:47
 * @version 2.2
 */
@Module
@InstallIn(SingletonComponent::class)
class HiltModule {
    @Provides
    @ApiUrl
    fun provideBaseUrl(): String = "https://www.wanandroid.com/"

    @Provides
    @OtherUrl
    fun provideOtherBaseUrl(): String = "https://www.baidu.com/"

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .build()

    @Singleton
    @Provides
    @ApiRetrofit
    fun provideApiRetrofit(okHttpClient: OkHttpClient, @ApiUrl baseUrl: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

    @Singleton
    @Provides
    @OtherRetrofit
    fun provideOtherRetrofit(okHttpClient: OkHttpClient, @OtherUrl baseUrl: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

    @Singleton
    @Provides
    fun provideOtherService(@OtherRetrofit retrofit: Retrofit): OtherService =
        retrofit.create(OtherService::class.java)

    @Singleton
    @Provides
    fun provideApiService(@ApiRetrofit retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)
}
