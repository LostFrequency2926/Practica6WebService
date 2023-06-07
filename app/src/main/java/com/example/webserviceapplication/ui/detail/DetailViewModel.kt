package com.example.webserviceapplication.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.webserviceapplication.local.model.LocalCharacter
import com.example.webserviceapplication.local.model.LocalMovie
import com.example.webserviceapplication.local.repository.LocalCharacterRepository
import com.example.webserviceapplication.local.repository.LocalMovieRepository
import com.example.webserviceapplication.server.model.Movie
import com.example.webserviceapplication.server.modelo.Character
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {

    private val localCharacterRepository = LocalCharacterRepository()

    private val _isMovieFavorite : MutableLiveData<Boolean> = MutableLiveData()
    val isMovieFavorite : LiveData<Boolean> = _isMovieFavorite

    fun saveCharacter(character: Character) {
        val localCharacter = LocalCharacter(
            id = character.id,
            name = character.name,
            status = character.status,
            species = character.species,
            type = character.type,
            gender = character.gender,
            image = character.image,
            created = character.created
        )

        viewModelScope.launch {
            localCharacterRepository.saveCharacter(localCharacter)
        }
    }

    fun searchCharacter(id: Int) {

        var characterFavorite = false

        viewModelScope.launch {
            val localCharacter = localCharacterRepository.searchCharacter(id)

            if(localCharacter != null)
                characterFavorite = true
            _isMovieFavorite.postValue(characterFavorite)
        }
    }
}