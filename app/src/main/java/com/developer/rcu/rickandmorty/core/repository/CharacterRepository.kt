package com.developer.rcu.rickandmorty.core.repository

import com.developer.rcu.rickandmorty.core.net.CharacterService
import com.developer.rcu.rickandmorty.core.net.NetResult
import com.developer.rcu.rickandmorty.core.utils.NetUtils
import com.developer.rcu.rickandmorty.model.PagedCharacters
import javax.inject.Inject

/**
 * Created by Raul Corvo on 27/11/2018
 */
class CharacterRepository @Inject constructor(private val characterService: CharacterService) {

    fun getCharacterList(page: Int): NetResult<PagedCharacters> = NetUtils.request(characterService.getCharacterList(page))
}