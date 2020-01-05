package com.developer.rcu.rickandmorty.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.WindowManager
import com.developer.rcu.rickandmorty.AndroidApplication
import com.developer.rcu.rickandmorty.R
import com.developer.rcu.rickandmorty.core.di.ApplicationComponent

class MainActivity : AppCompatActivity() {

    private val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (application as AndroidApplication).appComponent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)
        appComponent.inject(this)
    }
}
