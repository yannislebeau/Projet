package com.example.projet.presentation.api

import com.example.projet.presentation.list.Game

data class Gamelistresponse (
    val count : Int,
    val next : String,
    val results : List<Game>
)
