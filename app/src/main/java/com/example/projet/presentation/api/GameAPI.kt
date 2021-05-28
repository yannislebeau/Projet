package com.example.projet.presentation.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GameAPI {
    @GET("version")
    fun getGameList(@Query(  "limit") limit: String): Call<Gameresponse>
}