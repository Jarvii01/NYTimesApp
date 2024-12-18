package com.example.nytimesapp.screens.newsListScreen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.nytimesapp.NewsApp
import com.example.nytimesapp.R
import com.example.nytimesapp.databinding.FragmentTopStoryListBinding
import javax.inject.Inject

class TopStoryListFragment : Fragment(R.layout.fragment_top_story_list) {

    private val binding by lazy {
        FragmentTopStoryListBinding.inflate(layoutInflater)
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[TopStoryViewModel::class.java]
    }

    private val component by lazy {
        (requireActivity().application as NewsApp).component
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        component.inject(this)
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchNewsList()


    }

}
