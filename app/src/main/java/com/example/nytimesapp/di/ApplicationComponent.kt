package com.example.nytimesapp.di

import android.app.Application
import com.example.nytimesapp.NewsApp
import com.example.nytimesapp.di.annotation.ApplicationScope
import com.example.nytimesapp.di.module.DataModule
import com.example.nytimesapp.di.module.ViewModelModule
import com.example.nytimesapp.screens.MainActivity
import com.example.nytimesapp.screens.topStoryItem.TopStoryItemFragment
import com.example.nytimesapp.screens.topStoryListScreen.TopStoryListFragment
import com.google.gson.Gson
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    fun inject(application: NewsApp)

    fun inject(fragment: TopStoryListFragment)

    fun inject(fragment: TopStoryItemFragment)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application,
            @BindsInstance gson: Gson
        ): ApplicationComponent
    }

}
