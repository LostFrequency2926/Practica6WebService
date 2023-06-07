package com.example.webserviceapplication

import android.app.Application
import androidx.room.Room
import com.example.webserviceapplication.local.CharacterDataBase
import com.example.webserviceapplication.local.MovieDataBase

class WebServiceApplication : Application() {

    companion object{
        lateinit var database: MovieDataBase
        lateinit var databaseCharacter: CharacterDataBase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            this,
            MovieDataBase::class.java,
            "movie_db"
        ).build()

        databaseCharacter = Room.databaseBuilder(
            this,
            CharacterDataBase::class.java,
            "character_db"
        ).build()
    }
}