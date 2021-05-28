package com.example.projet.presentation.api

data class Gamedetailresponse (
    val effect_entries: List<Gameslot>,
    val name : String
)


data class Gameslot (
    val deutsch_effect : Paquet1,
    val english_effect : Paquet2
)

data class Paquet1 (
    val effect : String,
    val short_effect : String
)

data class Paquet2 (
    val effect : String,
    val short_effect : String
)