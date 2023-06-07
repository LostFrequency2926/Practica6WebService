package com.example.webserviceapplication.server

import com.example.webserviceapplication.server.model.MoviesList
import com.example.webserviceapplication.server.modelo.charactersList
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("character")
    //suspend fun loadMovies(@Query ("api_key") apiKey: String) : MoviesList
    suspend fun loadMovies() : charactersList

}