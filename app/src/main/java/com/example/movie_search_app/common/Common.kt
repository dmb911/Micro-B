package com.example.movie_search_app.common

import com.example.movie_search_app.interfaces.RetrofitServices
import com.example.movie_search_app.retrofit.RetrofitClient


object Common {
    private val BASE_URL = "https://api.tvmaze.com/"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}


