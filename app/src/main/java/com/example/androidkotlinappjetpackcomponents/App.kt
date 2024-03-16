package com.example.androidkotlinappjetpackcomponents

import android.app.Application
import com.example.androidkotlinappjetpackcomponents.api.ApiService
import com.example.androidkotlinappjetpackcomponents.api.RetrofitHelper
import com.example.androidkotlinappjetpackcomponents.repository.PostRepository

class App: Application() {
    lateinit var postRepository: PostRepository
    override fun onCreate() {
        super.onCreate()
        initiate()
    }

    private fun initiate() {
        val apiService = RetrofitHelper.getRetrofitInstance().create(ApiService::class.java)
        postRepository = PostRepository(apiService)
    }

}