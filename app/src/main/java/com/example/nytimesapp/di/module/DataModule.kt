package com.example.nytimesapp.di.module

import android.app.Application
import com.example.nytimesapp.data.newsList.repository.TopStoryRepository
import com.example.nytimesapp.data.mapper.NewsMapper
import com.example.nytimesapp.data.newsList.repository.RepositoryTopStoryDataSource
import com.example.nytimesapp.data.newsList.dataSource.TopStoryLocalDatasource
import com.example.nytimesapp.data.newsList.dataSource.TopStoryRemoteDatasource
import com.example.nytimesapp.data.newsList.retrofit.ApiFactory
import com.example.nytimesapp.data.newsList.retrofit.ApiService
import com.example.nytimesapp.data.newsList.retrofit.RetrofitTopStoryDataSource
import com.example.nytimesapp.data.newsList.room.AppDatabase
import com.example.nytimesapp.data.newsList.room.RoomTopStoryDataSource
import com.example.nytimesapp.data.newsList.room.dao.TopStoryDao
import com.example.nytimesapp.di.annotation.ApplicationScope
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindTopStoryRepository(impl: RepositoryTopStoryDataSource): TopStoryRepository

    companion object {
        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService {
            return ApiFactory.api
        }

        @Provides
        @ApplicationScope
        fun provideTopStoryRemoteDataSource(apiService: ApiService): TopStoryRemoteDatasource =
            RetrofitTopStoryDataSource(apiService)

        @Provides
        @ApplicationScope
        fun provideTopStoryLocalDataSource(
            application: Application,
        ): TopStoryLocalDatasource =
            RoomTopStoryDataSource(
                AppDatabase.getInstance(application).TopStoriesDao()
            )

        @Provides
        @ApplicationScope
        fun provideTopStoriesDao(
            application: Application
        ): TopStoryDao = AppDatabase.getInstance(application).TopStoriesDao()

    }


}
