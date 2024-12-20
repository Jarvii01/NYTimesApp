package com.example.nytimesapp.data.newsList.dataSource

import androidx.lifecycle.LiveData
import com.example.nytimesapp.data.newsList.room.dao.TopStoryEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface TopStoryLocalDatasource {

    fun getTopStoryList(): Flow<List<TopStoryEntity>>

}
