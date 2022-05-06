package com.example.sostechnomobile.util

import androidx.fragment.app.Fragment
import com.example.sostechnomobile.App

fun Fragment.getViewModelFactory(): ViewModelFactory {
        val repository = App.newsRepository
        return ViewModelFactory(repository, this)
    }