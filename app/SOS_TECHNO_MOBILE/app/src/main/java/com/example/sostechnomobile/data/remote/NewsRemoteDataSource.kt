package com.example.sostechnomobile.data.remote

import com.example.sostechnomobile.data.Article
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NewsRemoteDataSource {
    private  const val NEWS_URL = "https://newsapi.org/"

    private  val moshi = Moshi.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(NEWS_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    private val retrofitService : NewsAPIService by lazy {
        retrofit.create(NewsAPIService::class.java)
    }

    suspend fun getNews(): List<Article>{
        val news = retrofitService.getAllNews()
        return  news.allNews
    }
}