package com.example.webserviceapplication.local.repository

import com.example.webserviceapplication.WebServiceApplication
import com.example.webserviceapplication.local.MovieDAO
import com.example.webserviceapplication.local.model.LocalMovie

class LocalMovieRepository {

    suspend fun saveMovie(localMovie: LocalMovie) {
        val movieDAO: MovieDAO = WebServiceApplication.database.MovieDAO()
        movieDAO.saveMovie(localMovie)
    }

    suspend fun searchMovie(id: Int): LocalMovie {
        val movieDAO: MovieDAO = WebServiceApplication.database.MovieDAO()
        return movieDAO.searchMovie(id)
    }

    suspend fun loadFavoritesMovies(): MutableList<LocalMovie> {
        val movieDAO: MovieDAO = WebServiceApplication.database.MovieDAO()
        return movieDAO.loadFavoritesMovies()
    }

    suspend fun deleteFavoriteMovie(localMovie: LocalMovie) {
        val movieDAO: MovieDAO = WebServiceApplication.database.MovieDAO()
        movieDAO.deleteMovie(localMovie)
    }

}