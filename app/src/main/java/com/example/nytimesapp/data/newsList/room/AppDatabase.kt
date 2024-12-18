package com.example.nytimesapp.data.newsList.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.nytimesapp.data.newsList.room.dao.TopStoryDao
import com.example.nytimesapp.data.newsList.room.dao.TopStoryEntity
import com.example.nytimesapp.utils.Constants.DB_NAME

@Database(entities = [TopStoryEntity::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    companion object {

        private var db: AppDatabase? = null
        private val LOCK = Any()

        fun getInstance(context: Context): AppDatabase {
            db?.let { return it }
            synchronized(LOCK) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    DB_NAME
                ).build()
                db = instance

                return instance
            }
        }

    }

    abstract fun TopStoriesDao(): TopStoryDao
}
