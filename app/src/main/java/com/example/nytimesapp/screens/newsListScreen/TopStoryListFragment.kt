package com.example.nytimesapp.screens.newsListScreen

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.nytimesapp.NewsApp
import com.example.nytimesapp.R
import com.example.nytimesapp.data.newsList.room.dao.Converters
import com.example.nytimesapp.databinding.FragmentTopStoryListBinding
import com.example.nytimesapp.di.ViewModelFactory
import com.example.nytimesapp.screens.adapters.TopStoryAdapter
import com.google.gson.Gson
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class TopStoryListFragment : Fragment(R.layout.fragment_top_story_list) {

    private val component by lazy {
        (requireActivity().application as NewsApp).component
    }

    private var _binding: FragmentTopStoryListBinding? = null
    private val binding: FragmentTopStoryListBinding
        get() = _binding ?: throw RuntimeException("FragmentTopStoryListBinding is null")

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[TopStoryViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTopStoryListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val converters = Converters()
        val gson = Gson()
        val topStoryAdapter = TopStoryAdapter(converters, gson)
        binding.rvTopStory.adapter = topStoryAdapter
        lifecycleScope.launch {
            viewModel.loadData()
            viewModel.getTopStoryList().collectLatest {
//                    Log.d("MainActivityLog", viewModel.getTopStoryMultimedia().toString())
                Log.d("MainActivityLog", topStoryAdapter.itemCount.toString())
                topStoryAdapter.submitList(it)

            }
        }

    }
}



