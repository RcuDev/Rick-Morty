package com.developer.rcu.rickandmorty.core.di

import android.content.Context
import com.developer.rcu.rickandmorty.AndroidApplication
import com.developer.rcu.rickandmorty.core.utils.Constants.BASE_URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Raul Corvo on 27/11/2018
 */
@Module
class ApplicationModule(private val application: AndroidApplication) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = application

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(getGson()))
            .client(createClient())
            .build()

    private fun getGson(): Gson =
        GsonBuilder()
            .setLenient()
            .create()

    private fun createClient(): OkHttpClient =
        OkHttpClient.Builder()
            .build()
}