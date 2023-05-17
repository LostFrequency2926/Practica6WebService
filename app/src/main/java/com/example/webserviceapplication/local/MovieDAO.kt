package com.example.webserviceapplication.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.webserviceapplication.local.model.LocalMovie


@Dao
interface MovieDAO {

    @Insert
    suspend fun saveMovie(movie: LocalMovie)

    @Delete
    suspend fun deleteMovie(movie: LocalMovie)

    @Query("SELECT * FROM table_movies WHERE id LIKE :id")
    suspend fun searchMovie(id: Int): LocalMovie

    @Query("SELECT * FROM table_movies")
    suspend fun loadFavoritesMovies(): MutableList<LocalMovie>

}