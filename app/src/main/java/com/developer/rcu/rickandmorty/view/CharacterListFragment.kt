package com.developer.rcu.rickandmorty.view

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import androidx.navigation.findNavController
import com.developer.rcu.rickandmorty.R
import com.developer.rcu.rickandmorty.core.base.BaseFragment
import com.developer.rcu.rickandmorty.core.utils.Constants
import com.developer.rcu.rickandmorty.model.PagedCharacters
import com.developer.rcu.rickandmorty.view.adapter.CharacterListAdapter
import com.developer.rcu.rickandmorty.viewmodel.CharacterListViewModel
import kotlinx.android.synthetic.main.fragment_character_list.*
import javax.inject.Inject

/**
 * Created by Raul Corvo on 27/11/2018
 */
class CharacterListFragment : BaseFragment() {

    override fun layoutId() = R.layout.fragment_character_list

    @Inject
    lateinit var characterListAdapter: CharacterListAdapter
    @Inject
    lateinit var characterListViewModel: CharacterListViewModel

    private var firsLaunch: Boolean = true
    private var pageToLoad: Int = 1

    init {
        retainInstance = true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        initializeViewModelObservers()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
        firsLaunch = false
    }

    private fun initializeViewModelObservers() {
        characterListViewModel.loadCharacterList(pageToLoad).observe(this, Observer { pagedCharacter ->
            pagedCharacter?.let {
                renderCharacterList(pagedCharacter)
            }
        })
        characterListViewModel.onError().observe(this, Observer { errorMessage ->
            notifyWithAction(errorMessage ?: R.string.error_unknown, R.string.action_refresh, ::refreshCharacterList)
        })
    }

    private fun initializeView() {
        if (firsLaunch) {
            showProgress(R.string.action_message_character_loading)
        }
        characterListRV.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        characterListRV.adapter = characterListAdapter
        characterListAdapter.context = this.requireContext()
        characterListAdapter.clickListener = { character ->
            this.view?.let { view ->
                val bundle = Bundle()
                bundle.putParcelable(Constants.BUNDLE_CHARACTER, character)
                view.findNavController().navigate(R.id.action_characterList_to_characterDetail, bundle)
                Snackbar.make(view, "CHARACTER CLICKED: ${character.name}", Snackbar.LENGTH_LONG).show()
            }
        }
    }

    private fun renderCharacterList(pagedCharacters: PagedCharacters) {
        characterListAdapter.collection.addAll(pagedCharacters.results)
        characterListAdapter.notifyDataSetChanged()

        if (pageToLoad < pagedCharacters.info.pages) {
            pageToLoad++
            characterListViewModel.loadCharacterList(pageToLoad)
        } else {
            hideProgress()
        }
    }

    private fun refreshCharacterList() {
        showProgress(R.string.action_message_character_loading)
        characterListAdapter.collection = arrayListOf()
        characterListViewModel.loadCharacterList(pageToLoad)
    }
}
