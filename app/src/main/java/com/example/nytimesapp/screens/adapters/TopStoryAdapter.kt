package com.example.nytimesapp.screens.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.nytimesapp.data.newsList.room.dao.entity.TopStoryEntity
import com.example.nytimesapp.databinding.NewsCardBinding
import com.squareup.picasso.Picasso

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
        viewHolder.binding.rvDesc.text = news.description
//        Picasso.get(news.multimedia.first().)
        Log.d("TopStoryAdapter", viewHolder.binding.rvTitle.toString())

    }

}
