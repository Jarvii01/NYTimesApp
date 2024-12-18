package com.example.nytimesapp.data.mapper

import com.example.nytimesapp.data.newsList.room.dao.TopStoryEntity
import com.example.nytimesapp.data.newsList.model.TopStoryItemDto
import com.google.gson.Gson
import javax.inject.Inject

class NewsMapper @Inject constructor(
   private val gson: Gson
) {

    fun mapFromDtoToEntity(dto: TopStoryItemDto) = TopStoryEntity(
        title = dto.title,
        description = dto.abstract,
        url = dto.url,
        uri = dto.uri
    )



}
