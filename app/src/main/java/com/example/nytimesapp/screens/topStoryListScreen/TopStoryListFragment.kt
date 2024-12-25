package com.example.nytimesapp.screens.topStoryListScreen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.nytimesapp.NewsApp
import com.example.nytimesapp.R
import com.example.nytimesapp.data.newsList.room.dao.Converters
import com.example.nytimesapp.data.newsList.room.dao.entity.TopStoryEntity
import com.example.nytimesapp.databinding.FragmentTopStoryListBinding
import com.example.nytimesapp.di.ViewModelFactory
import com.example.nytimesapp.screens.adapters.TopStoryAdapter
import com.example.nytimesapp.screens.topStoryItem.TopStoryItemFragment
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
        ViewModelProvider(this, viewModelFactory)[TopStoryListViewModel::class.java]
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
                topStoryAdapter.submitList(it)
            }
        }
        topStoryAdapter.onTopStoryItemClickListener =
            object : TopStoryAdapter.OnTopStoryItemClickListener {
                override fun onStoryClick(topStoryItem: TopStoryEntity) {
                    launchTopStoryItemFragment(topStoryItem.title)
                }

            }
    }


    private fun launchTopStoryItemFragment(title: String) {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.top_story_list_fragment, TopStoryItemFragment().getInstance(title))
            ?.addToBackStack(null)
            ?.commit()

    }
}



