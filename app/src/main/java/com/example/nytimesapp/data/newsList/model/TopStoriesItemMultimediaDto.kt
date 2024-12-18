package com.example.nytimesapp.data.newsList.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TopStoriesItemMultimediaDto(

    @SerializedName("abstract")
    @Expose
    val caption: String,


    @SerializedName("copyright")
    @Expose
    val copyright: String,


    @SerializedName("format")
    @Expose
    val format: String,


    @SerializedName("height")
    @Expose
    val height: Int,


    @SerializedName("subtype")
    @Expose
    val subtype: String,


    @SerializedName("type")
    @Expose
    val type: String,


    @SerializedName("url")
    @Expose
    val url: String,


    @SerializedName("width")
    @Expose
    val width: Int
)
