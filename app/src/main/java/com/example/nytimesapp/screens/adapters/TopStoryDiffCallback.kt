package com.example.nytimesapp.screens.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.nytimesapp.data.newsList.room.dao.entity.TopStoryEntity

object TopStoryDiffCallback : DiffUtil.ItemCallback<TopStoryEntity>() {
    override fun areItemsTheSame(oldItem: TopStoryEntity, newItem: TopStoryEntity): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: TopStoryEntity, newItem: TopStoryEntity): Boolean {
        return oldItem == newItem
    }


}
