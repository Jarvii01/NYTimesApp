package com.example.nytimesapp.screens.topStoryListScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nytimesapp.data.newsList.repository.TopStoryRepository
import com.example.nytimesapp.data.newsList.room.dao.TopStoryDao
import kotlinx.coroutines.launch
import javax.inject.Inject

class TopStoryListViewModel @Inject constructor(
    private val repository: TopStoryRepository,
    private val dao: TopStoryDao
) : ViewModel() {

    fun loadData() = viewModelScope.launch {
        repository.loadData()
    }

    fun getTopStoryList() = repository.getTopStoryList()

//    fun getTopStoryMultimedia(title: String) = dao.getTopStoryMultimedia(title)


}


