package com.example.androidkotlinappjetpackcomponents.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.androidkotlinappjetpackcomponents.R
import com.example.androidkotlinappjetpackcomponents.models.Posts

class PostAdapter(
    private val posts: Posts
): RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_card, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int  = posts.size


    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.tvTitle.text = posts[position].title
        holder.tvPost.text = posts[position].body
    }
}

class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val tvTitle = itemView.findViewById<TextView>(R.id.tv_title)
    val tvPost = itemView.findViewById<TextView>(R.id.tv_body)
}
