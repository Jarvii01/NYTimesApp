package com.example.nytimesapp.data.newsList.retrofit

import com.example.nytimesapp.data.newsList.dataSource.TopStoryRemoteDatasource
import com.example.nytimesapp.data.newsList.model.TopStoriesListDto
import javax.inject.Inject


class RetrofitTopStoryDataSource @Inject constructor(
    private val apiService: ApiService
) : TopStoryRemoteDatasource {

    override suspend fun fetchNewsList(): TopStoriesListDto = apiService.fetchTopStoryResult()


}
