package com.example.nytimesapp.data.mapper

import com.example.nytimesapp.data.newsList.room.dao.entity.TopStoryEntity
import com.example.nytimesapp.data.newsList.model.TopStoryItemDto
import com.example.nytimesapp.data.newsList.room.dao.Converters
import com.google.gson.Gson
import javax.inject.Inject

class NewsMapper @Inject constructor(
    private val gson: Gson,
    private val converters: Converters
) {


    fun mapFromDtoToEntity(dto: TopStoryItemDto) = TopStoryEntity(
        title = dto.title,
        description = dto.abstract,
        url = dto.url,
        uri = dto.uri,
        multimedia = converters.fromJsonConverterMultimedia(gson.toJson(dto.multimedia)).toString()
    )


}
