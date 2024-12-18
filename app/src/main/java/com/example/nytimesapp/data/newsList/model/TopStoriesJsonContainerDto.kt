package com.example.nytimesapp.data.newsList.model

import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TopStoriesJsonContainerDto(

    @SerializedName("data")
    @Expose
    val json: JsonObject? = null
)
