package com.example.webserviceapplication.server.modelo


import com.google.gson.annotations.SerializedName

data class charactersList(
    @SerializedName("info")
    val info: Info?,
    @SerializedName("results")
    val characters: List<Character?>?
)