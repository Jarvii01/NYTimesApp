package com.example.nytimesapp.screens.topStoryItem

import androidx.lifecycle.ViewModel
import com.example.nytimesapp.data.newsList.repository.TopStoryRepository
import com.example.nytimesapp.data.newsList.room.dao.TopStoryDao
import javax.inject.Inject

class TopStoryItemViewModel @Inject constructor(
    private val repository: TopStoryRepository,
    private val dao: TopStoryDao
) : ViewModel() {

    fun getTopStoryItemByTitle(title: String) = dao.getTopStoryItemByTitle(title)


}
