package com.example.nytimesapp.data.newsList.dataSource

import com.example.nytimesapp.data.newsList.room.dao.entity.TopStoryEntity
import kotlinx.coroutines.flow.Flow

interface TopStoryLocalDatasource {

    fun getTopStoryList(): Flow<List<TopStoryEntity>>

    fun getTopStoryItemByTitle(title: String): Flow<TopStoryEntity>


}
