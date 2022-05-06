package com.example.sostechnomobile.data

import com.squareup.moshi.Json

data class News(@Json(name = "articles") val allNews: List<Article>)

data class Article (val title: String, @Json(name="urlToImage") val url: String)