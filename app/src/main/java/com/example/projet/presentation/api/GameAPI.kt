package com.example.projet.presentation.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GameAPI {
    @GET("ability")
    fun getGameList(@Query(  "limit") limit: String): Call<Gamelistresponse>

    @GET("ability/{id}")
    fun getGameDetail(@Path("id")  id: String): Call<Gamedetailresponse>
}