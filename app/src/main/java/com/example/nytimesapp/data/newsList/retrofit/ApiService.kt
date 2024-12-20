package com.example.nytimesapp.data.newsList.retrofit

import com.example.nytimesapp.data.newsList.model.TopStoriesListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("world.json")
    suspend fun fetchTopStoryResult(
        @Query("api-key") apiKey: String = "knZ3k9nHuJ2vAoe18dMvR4YDS7LaAYTT"
    ): TopStoriesListDto


}
