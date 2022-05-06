package com.example.sostechnomobile.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.sostechnomobile.R
import com.example.sostechnomobile.data.Article
import com.example.sostechnomobile.databinding.ItemnewsBinding
import com.squareup.picasso.Picasso

class NewsAdapter : androidx.recyclerview.widget.ListAdapter<Article, NewsAdapter.ViewHolder>(NewsDiffCallback()) {

    class ViewHolder(val binding: ItemnewsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindNews(magic: Article) {
            binding.title.text = magic.title
            Picasso.get()
                .load(magic.url)
                .error(R.drawable.ic_home_black_24dp)
                .placeholder(R.drawable.ic_home_black_24dp)
                .into(binding.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemnewsBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindNews(getItem(position))
    }

}

class NewsDiffCallback : DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }
}