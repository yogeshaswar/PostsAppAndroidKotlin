package com.example.androidkotlinappjetpackcomponents.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidkotlinappjetpackcomponents.api.ApiService
import com.example.androidkotlinappjetpackcomponents.models.Posts

class PostRepository(
    private val apiService: ApiService
) {
    private val postsLiveData = MutableLiveData<Posts>()
    val posts: LiveData<Posts>
        get() = postsLiveData

    
    
    suspend fun getPosts() {
        // TODO Add Network Check
        val result = apiService.getPosts()
        if(result?.body() != null) {
            postsLiveData.postValue(result.body())
        }
    }
    
}