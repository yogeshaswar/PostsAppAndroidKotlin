package com.example.androidkotlinappjetpackcomponents.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidkotlinappjetpackcomponents.models.Posts
import com.example.androidkotlinappjetpackcomponents.repository.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostViewModel(
    private val repository: PostRepository
) : ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getPosts()

        }
    }

    val posts: LiveData<Posts>
        get() = repository.posts
}