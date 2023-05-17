package com.example.webserviceapplication.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import okhttp3.internal.threadName
import java.security.cert.CertPath

@Entity(tableName = "table_movies")
data class LocalMovie(
    @PrimaryKey @ColumnInfo(name = "id") val id : Int?,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "poster_path") val posterPath: String?,
    @ColumnInfo(name = "release_date") val releaseDate : String?,
    @ColumnInfo(name = "vote_average") val voteAverage: Double?,
    @ColumnInfo(name = "overview") val overview: String?
    )

