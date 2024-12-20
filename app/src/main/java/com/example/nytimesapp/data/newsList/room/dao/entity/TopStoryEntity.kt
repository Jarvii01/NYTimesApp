package com.example.nytimesapp.data.newsList.room.dao.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.nytimesapp.data.newsList.room.dao.entity.TopStoryEntity.Companion.TABLE_NAME


@Entity(tableName = TABLE_NAME)
data class TopStoryEntity(

    @PrimaryKey
    @ColumnInfo("title")
    val title: String,

    @ColumnInfo("abstract")
    val description: String,

    @ColumnInfo("uri")
    val uri: String,

    @ColumnInfo("url")
    val url: String,

    @ColumnInfo("multimedia")
    val multimedia: String,

    ) {
    companion object {
        const val TABLE_NAME = "top_stories"
    }
}

