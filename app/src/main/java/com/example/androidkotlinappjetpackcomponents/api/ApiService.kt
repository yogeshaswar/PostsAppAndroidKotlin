package com.example.androidkotlinappjetpackcomponents.api

import com.example.androidkotlinappjetpackcomponents.models.Posts
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/posts")
    suspend fun getPosts(): Response<Posts>

}