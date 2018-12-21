package com.developer.rcu.rickandmorty.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Raul Corvo on 27/11/2018
 */
data class PagedCharacters(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: MutableList<Character>
)