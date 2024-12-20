package com.example.nytimesapp.data.newsList.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.nytimesapp.data.newsList.room.dao.Converters
import com.example.nytimesapp.data.newsList.room.dao.TopStoryDao
import com.example.nytimesapp.data.newsList.room.dao.entity.TopStoryEntity

const val DB_NAME = "news.db"


@Database(entities = [TopStoryEntity::class], version = 3, exportSchema = true)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    companion object {

        @Volatile
        private var db: AppDatabase? = null
        private val LOCK = Any()

        fun getInstance(context: Context): AppDatabase {
            db?.let { return it }
            synchronized(LOCK) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    DB_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
                db = instance

                return instance
            }
        }

    }

    abstract fun TopStoriesDao(): TopStoryDao
}
