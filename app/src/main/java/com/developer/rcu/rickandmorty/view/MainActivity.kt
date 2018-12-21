package com.developer.rcu.rickandmorty.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.developer.rcu.rickandmorty.AndroidApplication
import com.developer.rcu.rickandmorty.R
import com.developer.rcu.rickandmorty.core.di.ApplicationComponent

class MainActivity : AppCompatActivity() {

    private val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (application as AndroidApplication).appComponent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appComponent.inject(this)
    }
}
