package com.example.projet.presentation.api

import com.example.projet.presentation.list.Game

data class Gameresponse (
    val count : Int,
    val next : String,
    val results : List<Game>
)
