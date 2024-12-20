package com.example.nytimesapp.screens.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.nytimesapp.R
import com.example.nytimesapp.data.newsList.room.dao.TopStoryEntity
import com.example.nytimesapp.databinding.NewsCardBinding

class TopStoryAdapter : ListAdapter<TopStoryEntity, TopStoryViewHolder>(TopStoryDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopStoryViewHolder {
        val binding = NewsCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TopStoryViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: TopStoryViewHolder, position: Int) {
        val news = getItem(position)
        viewHolder.binding.rvTitle.text = news.title
        Log.d("TopStoryAdapter", viewHolder.binding.rvTitle.toString())

    }

}
