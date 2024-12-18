package com.example.nytimesapp.data.newsList.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TopStoriesListDto(
    @SerializedName("results")
    @Expose
    val results: List<TopStoryItemDto>
)


