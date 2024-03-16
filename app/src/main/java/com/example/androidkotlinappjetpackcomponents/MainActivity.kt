package com.example.androidkotlinappjetpackcomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidkotlinappjetpackcomponents.api.ApiService
import com.example.androidkotlinappjetpackcomponents.api.RetrofitHelper
import com.example.androidkotlinappjetpackcomponents.models.Posts
import com.example.androidkotlinappjetpackcomponents.repository.PostRepository
import com.example.androidkotlinappjetpackcomponents.viewmodels.PostViewModel
import com.example.androidkotlinappjetpackcomponents.viewmodels.PostViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var postViewModel: PostViewModel
    lateinit var repository: PostRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repository = (application as App).postRepository
        postViewModel = ViewModelProvider(this, PostViewModelFactory(repository)).get(PostViewModel::class.java)

        postViewModel.posts.observe(this, Observer { posts: Posts ->
            Log.d("TAG", "ApiResponse: ${posts.get(0)}")
        })

    }
}