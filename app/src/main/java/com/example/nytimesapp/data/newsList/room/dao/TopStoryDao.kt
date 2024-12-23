package com.example.nytimesapp.data.newsList.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nytimesapp.data.newsList.room.dao.entity.TopStoryEntity
import com.example.nytimesapp.data.newsList.room.dao.entity.TopStoryMultimediaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TopStoryDao {

    @Query("SELECT * FROM ${TopStoryEntity.TABLE_NAME}")
    fun getTopStoryList(): Flow<List<TopStoryEntity>>

    @Insert(entity = TopStoryEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTopStories(list: List<TopStoryEntity>)

//    @Query("SELECT multimedia FROM ${TopStoryEntity.TABLE_NAME}")
//    fun getTopStoryMultimedia(title: String): Flow<List<TopStoryMultimediaEntity>>

}
