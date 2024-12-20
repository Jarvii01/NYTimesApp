package com.example.nytimesapp.data.newsList.room

import androidx.lifecycle.LiveData
import com.example.nytimesapp.data.mapper.NewsMapper
import com.example.nytimesapp.data.newsList.dataSource.TopStoryLocalDatasource
import com.example.nytimesapp.data.newsList.model.TopStoryItemDto
import com.example.nytimesapp.data.newsList.room.dao.TopStoryDao
import com.example.nytimesapp.data.newsList.room.dao.TopStoryEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class RoomTopStoryDataSource @Inject constructor(
    private val dao: TopStoryDao,
    private val mapper: NewsMapper
) : TopStoryLocalDatasource {

    override fun getTopStoryList(): Flow<List<TopStoryEntity>> = dao.getNewsList()

}
