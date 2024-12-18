package com.example.nytimesapp.data.newsList.dataSource

import com.example.nytimesapp.data.newsList.model.TopStoryItemDto
import com.example.nytimesapp.data.newsList.room.dao.TopStoryEntity

interface TopStoryLocalDatasource {

    suspend fun getTopStoryList(): List<TopStoryEntity>

    suspend fun saveRemoteResponse(response: TopStoryItemDto)
}
