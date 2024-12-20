package com.example.nytimesapp.data

import androidx.lifecycle.LiveData
import com.example.nytimesapp.data.newsList.room.dao.TopStoryEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface TopStoryRepository {

    fun getTopStoryList(): Flow<List<TopStoryEntity>>

    suspend fun loadData()
}





