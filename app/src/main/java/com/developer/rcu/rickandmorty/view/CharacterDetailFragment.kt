package com.developer.rcu.rickandmorty.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.developer.rcu.rickandmorty.R
import com.developer.rcu.rickandmorty.core.base.BaseFragment
import com.developer.rcu.rickandmorty.core.utils.Constants
import com.developer.rcu.rickandmorty.databinding.FragmentCharacterDetailBinding
import com.developer.rcu.rickandmorty.model.network.Character
import kotlinx.android.synthetic.main.fragment_character_detail.*

/**
 * A simple [Fragment] subclass.
 *
 */
class CharacterDetailFragment : BaseFragment() {

    override fun layoutId() = R.layout.fragment_character_detail

    private lateinit var mBinding: FragmentCharacterDetailBinding
    private lateinit var mCharacterSelected: Character

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        initializeViewModelObservers()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mCharacterSelected = arguments?.getParcelable(Constants.BUNDLE_CHARACTER)!!
        mBinding = FragmentCharacterDetailBinding.inflate(inflater, container, false)
        mBinding.character = mCharacterSelected
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
    }

    private fun initializeViewModelObservers() {

    }

    private fun initializeView() {
        context?.let {
            Glide.with(it)
                .load(mCharacterSelected.image)
                .into(characterImage)
        }
    }
}
