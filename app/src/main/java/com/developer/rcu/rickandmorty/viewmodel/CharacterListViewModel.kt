package com.developer.rcu.rickandmorty.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.developer.rcu.rickandmorty.core.base.BaseViewModel
import com.developer.rcu.rickandmorty.core.iterators.GetCharacterListUseCase
import com.developer.rcu.rickandmorty.model.network.PagedCharacters
import javax.inject.Inject

/**
 * Created by Raul Corvo on 27/11/2018
 */
class CharacterListViewModel @Inject constructor(private val getCharacterList: GetCharacterListUseCase) :
    BaseViewModel() {

    private var characterList: MutableLiveData<PagedCharacters> = MutableLiveData()

    fun loadCharacterList(page: Int): LiveData<PagedCharacters> {
        characterList.value?.results.isNullOrEmpty().let {
            getCharacterList(page)
        }
        return characterList
    }

    fun onError(): LiveData<Int> = errorMessage

    private fun getCharacterList(page: Int) {
        getCharacterList(GetCharacterListUseCase.Param(page)) { characterList ->
            characterList.result(::setCharacterList, ::showError)
        }
    }

    private fun setCharacterList(pagedCharacters: PagedCharacters?) {
        pagedCharacters?.let {
            this.characterList.value = pagedCharacters
        }
    }
}