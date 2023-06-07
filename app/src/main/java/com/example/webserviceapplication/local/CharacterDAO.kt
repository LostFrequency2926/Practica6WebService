package com.example.webserviceapplication.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.webserviceapplication.local.model.LocalCharacter
import com.example.webserviceapplication.local.model.LocalMovie

@Dao
interface CharacterDAO {

    @Insert
    suspend fun saveCharacter(character: LocalCharacter)

    @Delete
    suspend fun deleteCharacter(character: LocalCharacter)

    @Query("SELECT * FROM table_characters WHERE id LIKE :id")
    suspend fun searchCharacter(id: Int): LocalCharacter

    @Query("SELECT * FROM table_characters")
    suspend fun loadFavoritesCharacters(): MutableList<LocalCharacter>

}