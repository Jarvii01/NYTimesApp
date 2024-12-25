package com.example.nytimesapp.di.module

import androidx.lifecycle.ViewModel
import com.example.nytimesapp.di.annotation.ViewModelKey
import com.example.nytimesapp.screens.topStoryItem.TopStoryItemViewModel
import com.example.nytimesapp.screens.topStoryListScreen.TopStoryListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(TopStoryListViewModel::class)
    fun bindNewsListViewModel(viewModel: TopStoryListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TopStoryItemViewModel::class)
    fun bindTopStoryItem(viewModel: TopStoryItemViewModel): ViewModel

}
