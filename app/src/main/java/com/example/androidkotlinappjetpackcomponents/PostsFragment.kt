package com.example.androidkotlinappjetpackcomponents

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidkotlinappjetpackcomponents.adapters.PostAdapter
import com.example.androidkotlinappjetpackcomponents.models.Posts
import com.example.androidkotlinappjetpackcomponents.repository.PostRepository
import com.example.androidkotlinappjetpackcomponents.viewmodels.PostViewModel
import com.example.androidkotlinappjetpackcomponents.viewmodels.PostViewModelFactory

class PostsFragment : Fragment() {

    lateinit var postViewModel: PostViewModel
    lateinit var repository: PostRepository
    lateinit var rvPosts: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_posts, container, false)

        // Inflate the layout for this fragment
        repository = (requireActivity().application as App).postRepository
        postViewModel = ViewModelProvider(this, PostViewModelFactory(repository)).get(PostViewModel::class.java)

        rvPosts = view.findViewById<RecyclerView>(R.id.rv_posts)
        rvPosts.layoutManager = LinearLayoutManager(context)

        postViewModel.posts.observe(this.viewLifecycleOwner, Observer { posts: Posts ->
            // TODO Add Recycler View
            rvPosts.adapter = PostAdapter(posts)
        })
        return view
    }

}