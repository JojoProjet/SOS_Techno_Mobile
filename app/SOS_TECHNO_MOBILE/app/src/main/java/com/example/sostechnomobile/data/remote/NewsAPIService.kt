package com.example.sostechnomobile.data.remote

import com.example.sostechnomobile.data.News
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPIService {
    @GET("/v2/top-headlines")
    suspend fun getAllNews(
        @Query("country") iso639:String = "fr",
        @Query("apiKey") apiKey:String = "06f5c95999f441c8b69482a26b44e65b"
    ): News
}