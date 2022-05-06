package com.example.sostechnomobile.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sostechnomobile.data.Article
import com.example.sostechnomobile.data.NewsRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class NewsViewModel(private val newsRepo: NewsRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Test"
    }
    val text: LiveData<String> = _text

    private val _list = MutableLiveData<List<Article>>()

    val list : LiveData<List<Article>>
        get() = _list

    init {
        getNews()
    }

    private fun getNews() {
        viewModelScope.launch {
            try {
                _list.value = newsRepo.getNews()
            }
            catch (e: Exception){
                _list.value = emptyList()
            }
        }
    }
}