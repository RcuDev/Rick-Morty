package com.developer.rcu.rickandmorty.core.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.developer.rcu.rickandmorty.R
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Created by Raul Corvo on 27/11/2018
 */
abstract class BaseViewModel : ViewModel() {

    protected var errorMessage: MutableLiveData<Int> = MutableLiveData()

    internal fun showError(exception: Exception) {
        when (exception) {
            is HttpException -> this.errorMessage.value = R.string.error_request
            is SocketTimeoutException -> this.errorMessage.value = R.string.error_server_maintenance
            is ConnectException -> this.errorMessage.value = R.string.error_not_connection
            is UnknownHostException -> this.errorMessage.value = R.string.error_not_connection
        }
    }
}