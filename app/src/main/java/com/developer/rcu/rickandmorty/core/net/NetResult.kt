package com.developer.rcu.rickandmorty.core.net

/**
 * Created by Raul Corvo on 27/11/2018
 */
sealed class NetResult<out T : Any> {
    data class Success<out T : Any>(val data: T?) : NetResult<T>()
    data class Error(val error: Exception) : NetResult<Nothing>()

    fun result(onSuccess: (T?) -> Any, onError: (Exception) -> Any) : Any =
        when(this) {
            is Success -> onSuccess(data)
            is Error -> onError(error)
        }
}