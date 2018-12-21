package com.developer.rcu.rickandmorty.core.di

import com.developer.rcu.rickandmorty.AndroidApplication
import com.developer.rcu.rickandmorty.view.CharacterDetailFragment
import com.developer.rcu.rickandmorty.view.CharacterListFragment
import com.developer.rcu.rickandmorty.view.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Raul Corvo on 27/11/2018
 */
@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(application: AndroidApplication)

    // MainActivity
    fun inject(mainActivity: MainActivity)

    // Character views
    fun inject(characterList: CharacterListFragment)

    fun inject(characterDetail: CharacterDetailFragment)
}