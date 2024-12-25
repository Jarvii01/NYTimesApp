package com.example.nytimesapp.data.newsList.room

import com.example.nytimesapp.data.newsList.dataSource.TopStoryLocalDatasource
import com.example.nytimesapp.data.newsList.room.dao.TopStoryDao
import com.example.nytimesapp.data.newsList.room.dao.entity.TopStoryEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RoomTopStoryDataSource @Inject constructor(
    private val dao: TopStoryDao
) : TopStoryLocalDatasource {

    override fun getTopStoryList(): Flow<List<TopStoryEntity>> = dao.getTopStoryList()

    override fun getTopStoryItemByTitle(title: String): Flow<TopStoryEntity> =
        dao.getTopStoryItemByTitle(title)

}
