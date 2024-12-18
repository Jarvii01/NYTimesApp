package com.example.nytimesapp.di.module

import androidx.lifecycle.ViewModel
import com.example.nytimesapp.di.annotation.ViewModelKey
import com.example.nytimesapp.screens.newsListScreen.TopStoryViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(TopStoryViewModel::class)
    fun bindNewsListViewModel(viewModel: TopStoryViewModel): ViewModel

}
