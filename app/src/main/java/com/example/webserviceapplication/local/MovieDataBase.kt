package com.example.webserviceapplication.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.webserviceapplication.local.model.LocalMovie

@Database(entities = [LocalMovie::class], version = 1)

abstract class MovieDataBase : RoomDatabase(){

    abstract fun MovieDAO(): MovieDAO

}