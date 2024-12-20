package com.example.nytimesapp.screens.newsListScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nytimesapp.data.TopStoryRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class TopStoryViewModel @Inject constructor(
    private val repository: TopStoryRepository
) : ViewModel() {

    fun loadData() = viewModelScope.launch {
        repository.loadData()
    }

     fun getTopStoryList() = repository.getTopStoryList()


}


