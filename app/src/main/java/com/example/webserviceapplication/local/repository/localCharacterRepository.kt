package com.example.webserviceapplication.local.repository

import com.example.webserviceapplication.WebServiceApplication
import com.example.webserviceapplication.local.CharacterDAO
import com.example.webserviceapplication.local.MovieDAO
import com.example.webserviceapplication.local.model.LocalCharacter
import com.example.webserviceapplication.local.model.LocalMovie
import com.example.webserviceapplication.server.CharacterDB
import com.example.webserviceapplication.server.modelo.Character

class LocalCharacterRepository {

    suspend fun saveCharacter(localCharacter: LocalCharacter) {
        val characterDAO: CharacterDAO = WebServiceApplication.databaseCharacter.CharacterDAO()
        characterDAO.saveCharacter(localCharacter)
    }

    suspend fun searchCharacter(id: Int): LocalCharacter {
        val characterDAO: CharacterDAO = WebServiceApplication.databaseCharacter.CharacterDAO()
        return characterDAO.searchCharacter(id)
    }

    suspend fun loadFavoritesCharacter(): MutableList<LocalCharacter> {
        val characterDAO: CharacterDAO = WebServiceApplication.databaseCharacter.CharacterDAO()
        return characterDAO.loadFavoritesCharacters()
    }

    suspend fun deleteFavoriteCharacter(localCharacter: LocalCharacter) {
        val characterDAO: CharacterDAO = WebServiceApplication.databaseCharacter.CharacterDAO()
        characterDAO.deleteCharacter(localCharacter)
    }

}