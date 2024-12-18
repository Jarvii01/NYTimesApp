package com.example.nytimesapp.data.newsList.dataSource

import com.example.nytimesapp.data.newsList.model.TopStoriesListDto

interface TopStoryRemoteDatasource {

    suspend fun fetchNewsList(): TopStoriesListDto

}
