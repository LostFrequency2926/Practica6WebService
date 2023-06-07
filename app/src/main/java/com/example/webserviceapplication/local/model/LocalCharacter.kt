package com.example.webserviceapplication.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "table_characters")
data class LocalCharacter (
    @PrimaryKey @ColumnInfo(name = "id") val id : Int?,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "status") val status: String?,
    @ColumnInfo(name = "species") val species : String?,
    @ColumnInfo(name = "type") val type: String?,
    @ColumnInfo(name = "gender") val gender: String?,
    @ColumnInfo(name = "image") val image: String?,
    @ColumnInfo(name = "created") val created: String?
)