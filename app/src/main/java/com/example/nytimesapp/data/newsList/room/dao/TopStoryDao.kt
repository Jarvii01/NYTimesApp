package com.example.nytimesapp.data.newsList.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

private const val TABLE_NAME = "top_stories"

@Dao
interface TopStoryDao {

    @Query("SELECT * FROM $TABLE_NAME")
    fun getNewsList(): Flow<List<TopStoryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTopStories(list: List<TopStoryEntity>)

}
