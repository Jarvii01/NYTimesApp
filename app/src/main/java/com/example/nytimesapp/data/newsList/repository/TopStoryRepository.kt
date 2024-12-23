package com.example.nytimesapp.data.newsList.repository

import com.example.nytimesapp.data.newsList.room.dao.entity.TopStoryEntity
import com.example.nytimesapp.data.newsList.room.dao.entity.TopStoryMultimediaEntity
import kotlinx.coroutines.flow.Flow

interface TopStoryRepository {

    suspend fun loadData()

    fun getTopStoryList(): Flow<List<TopStoryEntity>>

//    fun getTopStoryMultimedia(): Flow<List<TopStoryMultimediaEntity>>

}





