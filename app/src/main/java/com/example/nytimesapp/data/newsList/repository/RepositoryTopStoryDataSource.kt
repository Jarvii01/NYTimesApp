package com.example.nytimesapp.data.newsList.repository

import android.app.Application
import com.example.nytimesapp.data.TopStoryRepository
import com.example.nytimesapp.data.mapper.NewsMapper
import com.example.nytimesapp.data.newsList.dataSource.TopStoryLocalDatasource
import com.example.nytimesapp.data.newsList.dataSource.TopStoryRemoteDatasource
import com.example.nytimesapp.data.newsList.model.TopStoryItemDto
import com.example.nytimesapp.data.newsList.room.dao.TopStoryDao
import javax.inject.Inject

class RepositoryTopStoryDataSource @Inject constructor(
    private val topStoryRemoteDatasource: TopStoryRemoteDatasource,
    private val topStoryLocalDatasource: TopStoryLocalDatasource,
    private val mapper: NewsMapper,
    private val dao: TopStoryDao,
) : TopStoryRepository {

    override suspend fun getTopStories(): List<TopStoryItemDto> =
        topStoryRemoteDatasource.fetchNewsList().results

    override suspend fun loadData() {
        val topStoriesItemDto = topStoryRemoteDatasource.fetchNewsList().results
        val topStoryList = topStoriesItemDto.map { mapper.mapFromDtoToEntity(it) }
        dao.addTopStories(topStoryList)
    }

}
