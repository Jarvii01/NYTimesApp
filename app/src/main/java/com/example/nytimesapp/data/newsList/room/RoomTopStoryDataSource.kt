package com.example.nytimesapp.data.newsList.room

import com.example.nytimesapp.data.mapper.NewsMapper
import com.example.nytimesapp.data.newsList.dataSource.TopStoryLocalDatasource
import com.example.nytimesapp.data.newsList.model.TopStoryItemDto
import com.example.nytimesapp.data.newsList.room.dao.TopStoryDao
import com.example.nytimesapp.data.newsList.room.dao.TopStoryEntity
import javax.inject.Inject

class RoomTopStoryDataSource @Inject constructor(
    private val dao: TopStoryDao,
    private val mapper: NewsMapper
) : TopStoryLocalDatasource {

    override suspend fun getTopStoryList(): List<TopStoryEntity> = dao.getNewsList()

    override suspend fun saveRemoteResponse(response: TopStoryItemDto) {
        mapper.mapFromDtoToEntity(response)
    }
}
