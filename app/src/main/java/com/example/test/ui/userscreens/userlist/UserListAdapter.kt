package com.example.test.ui.userscreens.userlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.ui.model.UserDataVO

class UserListAdapter(val onItemClickListener: (UserDataVO) -> Unit) :
    ListAdapter<UserDataVO, UserListAdapter.UserViewHolder>(ItemDiffCallback()) {

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.user_name)
        fun bind(item: UserDataVO) {
            nameTextView.text = item.name
            itemView.setOnClickListener { onItemClickListener.invoke(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_item, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }
}

class ItemDiffCallback : DiffUtil.ItemCallback<UserDataVO>() {
    override fun areItemsTheSame(oldItem: UserDataVO, newItem: UserDataVO): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserDataVO, newItem: UserDataVO): Boolean {
        return oldItem.name == newItem.name
    }
}