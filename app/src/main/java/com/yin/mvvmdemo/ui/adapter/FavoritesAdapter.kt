package com.yin.mvvmdemo.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yin.mvvmdemo.databinding.ItemFavoritesBinding
import com.yin.mvvmdemo.db.entity.Product

class FavoritesAdapter : ListAdapter<Product, RecyclerView.ViewHolder>(FavoritesDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolde(
            ItemFavoritesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MyViewHolde).bind(getItem(position))
    }

    class MyViewHolde(private val binding: ItemFavoritesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                Log.w("scj", "item click position:" + adapterPosition + " : " + position)
            }
        }

        fun bind(product: Product) {
            binding.products = product
            binding.executePendingBindings()
        }
    }
}


private class FavoritesDiffCallback : DiffUtil.ItemCallback<Product>() {


    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }
}