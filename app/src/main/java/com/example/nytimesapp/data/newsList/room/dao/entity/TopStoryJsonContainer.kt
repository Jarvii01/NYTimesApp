package com.example.nytimesapp.data.newsList.room.dao.entity

import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TopStoryJsonContainer(
    @SerializedName("RAW")
    @Expose
    val json: JsonObject? = null
)
