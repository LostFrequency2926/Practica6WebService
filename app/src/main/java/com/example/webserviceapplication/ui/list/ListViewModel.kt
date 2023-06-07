package com.example.webserviceapplication.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.webserviceapplication.server.model.Movie
import com.example.webserviceapplication.server.model.MoviesList
import com.example.webserviceapplication.server.modelo.Character
import com.example.webserviceapplication.server.modelo.charactersList
import com.example.webserviceapplication.server.repository.CharacterRepository
import com.example.webserviceapplication.server.repository.MoviesRespository
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {

    val characterRepository = CharacterRepository()

    private val _charactersLoaded : MutableLiveData<ArrayList<Character>> = MutableLiveData()
    val charactersLoaded: LiveData<ArrayList<Character>> = _charactersLoaded

    fun loadMovies() {
        viewModelScope.launch {
            val charactersList: charactersList = characterRepository.loadCharacters()
            _charactersLoaded.postValue(charactersList.characters as ArrayList<Character>)
        }
    }
}