package com.example.projet.presentation.list

import com.example.projet.presentation.api.GameAPI
import com.example.projet.presentation.list.GameApplication.Companion.context
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.security.AccessControlContext

class Singleton {
    companion object {

        var cache: Cache = Cache(File(context?.cacheDir,"responses"), 10 * 1024 * 1024)// 10 MiB
        val okhttpClient: OkHttpClient = OkHttpClient().newBuilder()
            .cache(cache)
            .build()

        val gameAPI: GameAPI = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okhttpClient)
            .build()
            .create(GameAPI::class.java)
    }
}
