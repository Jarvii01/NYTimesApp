package com.example.nytimesapp.data.newsList.room.dao

import androidx.room.TypeConverter
import com.example.nytimesapp.data.newsList.model.TopStoriesMultimediaDto
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class Converters @Inject constructor() {

    @TypeConverter
    fun fromJsonConverterMultimedia(multimedia: String?): List<TopStoriesMultimediaDto>? {
        val type = object : TypeToken<List<TopStoriesMultimediaDto>>() {}.type
        return Gson().fromJson<List<TopStoriesMultimediaDto>>(multimedia, type)

    }

    @TypeConverter
    fun toJsonConverterMultimedia(multimedia: List<TopStoriesMultimediaDto>?): String? {
        val type = object : TypeToken<List<TopStoriesMultimediaDto>>() {}.type
        return Gson().toJson(multimedia, type)

    }
}
