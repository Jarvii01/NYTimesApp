package com.example.nytimesapp.screens.newsListScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nytimesapp.data.mapper.NewsMapper
import com.example.nytimesapp.data.TopStoryRepository
import com.example.nytimesapp.data.newsList.dataSource.TopStoryRemoteDatasource
import com.example.nytimesapp.data.newsList.room.dao.TopStoryDao
import kotlinx.coroutines.launch
import javax.inject.Inject

class TopStoryViewModel @Inject constructor(
    private val repository: TopStoryRepository,
    private val dao: TopStoryDao,
    private val mapper: NewsMapper,
    private val topStoryRemoteDatasource: TopStoryRemoteDatasource
) : ViewModel() {

    fun fetchNewsList() {
        viewModelScope.launch {
            repository.loadData()
        }
    }


}
