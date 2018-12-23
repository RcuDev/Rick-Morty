package com.developer.rcu.rickandmorty.view

import android.os.Bundle
import android.view.View
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.developer.rcu.rickandmorty.R
import com.developer.rcu.rickandmorty.core.base.BaseFragment
import kotlinx.coroutines.*

/**
 * Created by Raul Corvo on 23/12/2018
 */
class SplashFragment : BaseFragment() {

    override fun layoutId() = R.layout.fragment_splash

    var job: Job? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        GlobalScope.run {
            job = async(Dispatchers.Default) { Thread.sleep(3000) }
            launch(Dispatchers.Main) {
                (job as Deferred<*>).await()
                navigateToCharacterList()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job?.cancel()
    }

    private fun navigateToCharacterList() {
        findNavController().navigate(
            R.id.action_splash_to_characterList, null,
            NavOptions.Builder().setPopUpTo(R.id.splashScreen, true)
                .build())
    }
}
