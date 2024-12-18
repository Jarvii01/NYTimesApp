package com.example.nytimesapp.data.newsList.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nytimesapp.utils.Constants.TABLE_NAME

@Dao
interface TopStoryDao {

    @Query("SELECT * FROM $TABLE_NAME")
    suspend fun getNewsList(): List<TopStoryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTopStories(list: List<TopStoryEntity>)

}
