package com.developer.rcu.rickandmorty.core.net

import com.developer.rcu.rickandmorty.model.PagedCharacters
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Raul Corvo on 27/11/2018
 */
internal interface CharacterApiService {

    @GET("character/")
    fun getCharacterList(@Query("page") page: Int): Call<PagedCharacters>
}