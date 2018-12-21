package com.developer.rcu.rickandmorty.core.net

import com.developer.rcu.rickandmorty.model.PagedCharacters
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Raul Corvo on 27/11/2018
 */
@Singleton
class CharacterService @Inject constructor(retrofit: Retrofit) : CharacterApiService {

    private val apiService by lazy { retrofit.create(CharacterApiService::class.java) }

    override fun getCharacterList(page: Int): Call<PagedCharacters> = apiService.getCharacterList(page)
}