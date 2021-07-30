package com.example.movie_search_app.`interfaces`


import com.example.movie_search_app.model.Movie
import retrofit2.Call
import retrofit2.http.*

interface RetrofitServices {
    @GET("shows")
    fun getMovieList(): Call<MutableList<Movie>>
}