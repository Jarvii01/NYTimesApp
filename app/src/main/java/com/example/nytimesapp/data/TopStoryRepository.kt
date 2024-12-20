package com.example.nytimesapp.data

import com.example.nytimesapp.data.newsList.room.dao.entity.TopStoryEntity
import kotlinx.coroutines.flow.Flow

interface TopStoryRepository {

    fun getTopStoryList(): Flow<List<TopStoryEntity>>

    suspend fun loadData()
}





