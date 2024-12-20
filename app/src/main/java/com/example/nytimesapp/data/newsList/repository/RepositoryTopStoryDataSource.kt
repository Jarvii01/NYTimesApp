package com.example.nytimesapp.data.newsList.repository

import com.example.nytimesapp.data.TopStoryRepository
import com.example.nytimesapp.data.mapper.NewsMapper
import com.example.nytimesapp.data.newsList.dataSource.TopStoryLocalDatasource
import com.example.nytimesapp.data.newsList.dataSource.TopStoryRemoteDatasource
import com.example.nytimesapp.data.newsList.room.dao.TopStoryDao
import com.example.nytimesapp.data.newsList.room.dao.TopStoryEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryTopStoryDataSource @Inject constructor(
    private val topStoryRemoteDatasource: TopStoryRemoteDatasource,
    private val topStoryLocalDatasource: TopStoryLocalDatasource,
    private val mapper: NewsMapper,
    private val dao: TopStoryDao,
) : TopStoryRepository {

    override suspend fun loadData() {
        val topStoriesItemDto = topStoryRemoteDatasource.fetchNewsList().results
        val topStoryList = topStoriesItemDto.map { mapper.mapFromDtoToEntity(it) }
        dao.addTopStories(topStoryList)


    }

    override fun getTopStoryList(): Flow<List<TopStoryEntity>> =
        topStoryLocalDatasource.getTopStoryList()


}
