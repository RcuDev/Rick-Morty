package com.developer.rcu.rickandmorty.view

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.developer.rcu.rickandmorty.R
import com.developer.rcu.rickandmorty.core.base.BaseFragment
import com.developer.rcu.rickandmorty.core.utils.Constants
import com.developer.rcu.rickandmorty.databinding.FragmentCharacterDetailBinding
import com.developer.rcu.rickandmorty.model.Character
import kotlinx.android.synthetic.main.fragment_character_detail.*

/**
 * A simple [Fragment] subclass.
 *
 */
class CharacterDetailFragment : BaseFragment() {

    override fun layoutId() = R.layout.fragment_character_detail

    private var characterSelected: Character? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        initializeViewModelObservers()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding: FragmentCharacterDetailBinding = DataBindingUtil.inflate(inflater, layoutId(), container, false)
        characterSelected = arguments?.getParcelable(Constants.BUNDLE_CHARACTER)
        binding.setVariable(Constants.CHARACTER_BINDING_ID, characterSelected)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
    }

    private fun initializeViewModelObservers() {

    }

    private fun initializeView() {
        Glide.with(context)
            .load(characterSelected?.image)
            .into(characterImage)
    }
}
