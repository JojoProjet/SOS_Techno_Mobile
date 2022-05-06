package com.example.sostechnomobile.data

import com.example.sostechnomobile.data.remote.NewsRemoteDataSource

class NewsRepository(private  val newsDataSource: NewsRemoteDataSource){
    suspend fun getNews() = newsDataSource.getNews()
}