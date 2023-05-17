package com.example.webserviceapplication.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.webserviceapplication.server.model.Movie
import com.example.webserviceapplication.server.model.MoviesList
import com.example.webserviceapplication.server.repository.MoviesRespository
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {

    val moviesRespository = MoviesRespository()

    private val _moviesLoaded : MutableLiveData<ArrayList<Movie>> = MutableLiveData()
    val moviesLoaded: LiveData<ArrayList<Movie>> = _moviesLoaded

    fun loadMovies() {
        viewModelScope.launch {
            val moviesList: MoviesList = moviesRespository.loadMovies()
            _moviesLoaded.postValue(moviesList.movies as ArrayList<Movie>)
        }
    }
}