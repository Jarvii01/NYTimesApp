package com.example.nytimesapp.data

import com.example.nytimesapp.data.newsList.model.TopStoryItemDto

interface TopStoryRepository{

    suspend fun getTopStories(): List<TopStoryItemDto>

    suspend fun loadData()

}





