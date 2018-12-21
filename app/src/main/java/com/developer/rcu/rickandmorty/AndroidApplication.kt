package com.developer.rcu.rickandmorty

import android.app.Application
import com.developer.rcu.rickandmorty.core.di.ApplicationComponent
import com.developer.rcu.rickandmorty.core.di.ApplicationModule
import com.developer.rcu.rickandmorty.core.di.DaggerApplicationComponent

/**
 * Created by Raul Corvo on 27/11/2018
 */
class AndroidApplication : Application() {

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        this.injectMembers()
    }

    private fun injectMembers() = appComponent.inject(this)
}