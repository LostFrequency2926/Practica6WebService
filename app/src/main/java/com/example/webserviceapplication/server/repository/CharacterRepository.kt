package com.example.webserviceapplication.server.repository

import com.example.webserviceapplication.server.CharacterDB
import com.example.webserviceapplication.server.MovieDB

class CharacterRepository {

    suspend fun loadCharacters() = CharacterDB.retrofit.loadMovies()
}