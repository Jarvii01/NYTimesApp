package com.example.nytimesapp.data.newsList.repository

import com.example.nytimesapp.data.newsList.room.dao.entity.TopStoryEntity
import kotlinx.coroutines.flow.Flow

interface TopStoryRepository {

    suspend fun loadData()

    fun getTopStoryList(): Flow<List<TopStoryEntity>>

    fun getTopStoryItemByTitle(title: String): Flow<TopStoryEntity>

}





