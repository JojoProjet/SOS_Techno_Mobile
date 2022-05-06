package com.example.sostechnomobile

import android.app.Application
import com.example.sostechnomobile.data.NewsRepository
import com.example.sostechnomobile.data.remote.NewsRemoteDataSource

class App : Application() {

    companion object {
        lateinit var instance: App

        val newsRepository by lazy {
            NewsRepository(NewsRemoteDataSource)
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}