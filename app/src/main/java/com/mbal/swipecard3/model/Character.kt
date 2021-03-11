package com.mbal.swipecard3.model

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val image: String,
    val url: String,
    val location: Location
)