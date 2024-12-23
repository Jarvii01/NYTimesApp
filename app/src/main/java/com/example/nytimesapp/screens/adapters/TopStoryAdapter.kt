package com.example.nytimesapp.screens.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.nytimesapp.data.newsList.room.dao.Converters
import com.example.nytimesapp.data.newsList.room.dao.entity.TopStoryEntity
import com.example.nytimesapp.databinding.NewsCardBinding
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import javax.inject.Inject

class TopStoryAdapter @Inject constructor(
    private val converters: Converters,
    private val gson: Gson
) : ListAdapter<TopStoryEntity, TopStoryViewHolder>(TopStoryDiffCallback) {

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
        Log.d("TopStoryAdapter", gson.toJson(news.multimedia))
        Picasso.get()
            .load("https://static01.nyt.com/images/2024/12/19/multimedia/19france-mayotte-promo/19france-mayotte-sub-01-bclt-superJumbo.jpg")
            .into(viewHolder.binding.ivNews)

    }

}
