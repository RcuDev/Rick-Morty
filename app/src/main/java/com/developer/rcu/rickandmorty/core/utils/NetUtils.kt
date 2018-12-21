package com.developer.rcu.rickandmorty.core.utils

import com.developer.rcu.rickandmorty.core.net.NetResult
import retrofit2.Call
import retrofit2.HttpException

/**
 * Created by Raul Corvo on 27/11/2018
 */
object NetUtils {

    fun <T: Any> request(call: Call<T>) =
        try {
            val response = call.execute()
            when (response.isSuccessful) {
                true -> NetResult.Success(response.body())
                false -> NetResult.Error(HttpException(response))
            }
        } catch (exception: Exception) {
            NetResult.Error(exception)
        }
}