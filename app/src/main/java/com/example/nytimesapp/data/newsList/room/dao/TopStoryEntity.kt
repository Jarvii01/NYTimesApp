package com.example.nytimesapp.data.newsList.room.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.nytimesapp.utils.Constants.TABLE_NAME

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
    val url: String

)


