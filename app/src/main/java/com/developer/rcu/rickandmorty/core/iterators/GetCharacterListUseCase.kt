package com.developer.rcu.rickandmorty.core.iterators

import com.developer.rcu.rickandmorty.core.repository.CharacterRepository
import com.developer.rcu.rickandmorty.model.network.PagedCharacters
import javax.inject.Inject

/**
 * Created by Raul Corvo on 27/11/2018
 */
class GetCharacterListUseCase @Inject constructor(private val characterRepository: CharacterRepository) :
    UseCase<GetCharacterListUseCase.Param, PagedCharacters>() {

    override suspend fun run(param: Param) = characterRepository.getCharacterList(param.page)

    data class Param(
        val page: Int
    )
}