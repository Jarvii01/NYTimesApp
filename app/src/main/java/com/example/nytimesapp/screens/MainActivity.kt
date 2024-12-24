package com.example.nytimesapp.screens

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.nytimesapp.NewsApp
import com.example.nytimesapp.R
import com.example.nytimesapp.databinding.ActivityMainBinding
import com.example.nytimesapp.screens.newsListScreen.TopStoryListFragment

class MainActivity : AppCompatActivity() {

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
        launchTopStoryListFragment()

    }

    private fun launchTopStoryListFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, TopStoryListFragment())
            .commit()
    }

}


