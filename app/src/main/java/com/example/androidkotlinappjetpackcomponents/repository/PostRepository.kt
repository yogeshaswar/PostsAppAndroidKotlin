package com.example.androidkotlinappjetpackcomponents.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidkotlinappjetpackcomponents.api.ApiService
import com.example.androidkotlinappjetpackcomponents.models.Posts
import com.example.androidkotlinappjetpackcomponents.utils.NetworkUtils

class PostRepository(
    private val apiService: ApiService,
    private val context: Context
) {
    private val postsLiveData = MutableLiveData<Posts>()
    val posts: LiveData<Posts>
        get() = postsLiveData

    
    
    suspend fun getPosts() {
        if(NetworkUtils.isInternetAvailable(context)) {
            val result = apiService.getPosts()
            if(result?.body() != null) {
                postsLiveData.postValue(result.body())
            }

        } else {
            // TODO Handle Offline (Room Storage)
            // TODO Show Toast for Network Unavailable

        }
    }
    
}