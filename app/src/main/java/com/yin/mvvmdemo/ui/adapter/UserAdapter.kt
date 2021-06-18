package com.yin.mvvmdemo.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yin.mvvmdemo.databinding.ItemUserBinding
import com.yin.mvvmdemo.viewmodel.User

class UserAdapter(private val users: List<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User, position: Int) {
            binding.position = position
            binding.user = user
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup) = UserViewHolder(
                ItemUserBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    interface OnItemClickListener {
        fun onItemClick(item: User, position: Int)
    }

    private val onItemClickListener = object : OnItemClickListener {
        override fun onItemClick(item: User, position: Int) {
            Log.w("scj", "user->" + item.toString() + " position:" + position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder.from(parent)

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        Log.w("scj", "onBindViewHolder...")
        val currentUser = users.get(position)
        holder.binding.onItemClickListener = onItemClickListener
        holder.bind(currentUser, position)
    }

    override fun getItemCount(): Int = users.size
}