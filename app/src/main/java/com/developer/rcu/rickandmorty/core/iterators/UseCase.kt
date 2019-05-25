package com.developer.rcu.rickandmorty.core.iterators

import androidx.annotation.UiThread
import com.developer.rcu.rickandmorty.core.net.NetResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

/**
 * Created by Raul Corvo on 27/11/2018
 */
abstract class UseCase<in P, out T : Any> {

    @UiThread
    abstract suspend fun run(param: P): NetResult<T>

    operator fun invoke(param: P, onResult: (NetResult<T>) -> Unit = {}) {
        GlobalScope.run {
            val job = async(Dispatchers.Default) { run(param) }
            launch(Dispatchers.Main) { onResult(job.await()) }
        }
    }
}