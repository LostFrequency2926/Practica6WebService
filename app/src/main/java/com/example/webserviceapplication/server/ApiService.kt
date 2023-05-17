package com.example.webserviceapplication.server

import com.example.webserviceapplication.server.model.MoviesList
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    suspend fun loadMovies(@Query ("api_key") apiKey: String) : MoviesList

}