package com.example.webserviceapplication.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.webserviceapplication.local.model.LocalMovie
import com.example.webserviceapplication.local.repository.LocalMovieRepository
import kotlinx.coroutines.launch

class FavoriteViewModel : ViewModel() {

    private val localMovieRepository = LocalMovieRepository()
    private val _favoriteMovies: MutableLiveData<ArrayList<LocalMovie>> = MutableLiveData()
    val favoriteMovies: LiveData<ArrayList<LocalMovie>> = _favoriteMovies

    fun loadFavoriteMovies() {
        viewModelScope.launch {
            val listFavoritesMovies = localMovieRepository.loadFavoritesMovies()
            _favoriteMovies.postValue(listFavoritesMovies as ArrayList<LocalMovie>)
        }
    }

    fun deleteFavoriteMovie(localMovie: LocalMovie) {
        viewModelScope.launch {
            localMovieRepository.deleteFavoriteMovie(localMovie)
        }
    }
}