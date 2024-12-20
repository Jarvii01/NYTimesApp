package com.example.nytimesapp.screens

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.nytimesapp.NewsApp
import com.example.nytimesapp.R
import com.example.nytimesapp.databinding.ActivityMainBinding
import com.example.nytimesapp.screens.adapters.TopStoryAdapter
import com.example.nytimesapp.screens.newsListScreen.TopStoryViewModel
import com.example.nytimesapp.screens.newsListScreen.ViewModelFactory
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[TopStoryViewModel::class.java]
    }

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val component by lazy {
        (application as NewsApp).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val topStoryAdapter = TopStoryAdapter()
        binding.rvTopStory.adapter = topStoryAdapter

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.loadData()
                viewModel.getTopStoryList().collect {
                    Log.d("MainActivityLog", topStoryAdapter.itemCount.toString())
                    topStoryAdapter.submitList(it)

                }
            }
        }

    }

}


