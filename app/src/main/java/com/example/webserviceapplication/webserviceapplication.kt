package com.example.webserviceapplication

import android.app.Application
import androidx.room.Room
import com.example.webserviceapplication.local.MovieDataBase

class WebServiceApplication : Application() {

    companion object{
        lateinit var database: MovieDataBase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            this,
            MovieDataBase::class.java,
            "movie_db"
        ).build()
    }
}