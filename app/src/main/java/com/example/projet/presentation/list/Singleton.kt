package com.example.projet.presentation.list

import com.example.projet.presentation.api.GameAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
class Singleton {
    companion object{
         val gameAPI: GameAPI = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GameAPI::class.java)
    }
}
