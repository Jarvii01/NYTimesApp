package com.example.nytimesapp.data.newsList.room.dao.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.example.nytimesapp.data.newsList.room.dao.entity.TopStoryMultimediaEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class TopStoryMultimediaEntity(

    @ColumnInfo("abstract")
    val caption: String,

    @ColumnInfo("copyright")
    val copyright: String,

    @ColumnInfo("format")
    val format: String,

    @ColumnInfo("height")
    val height: Int,

    @ColumnInfo("subtype")
    val subtype: String,

    @ColumnInfo("type")
    val type: String,

    @ColumnInfo("url")
    val url: String,

    @ColumnInfo("width")
    val width: Int
) {
    companion object {
        const val TABLE_NAME = "multimedia"
    }
}
