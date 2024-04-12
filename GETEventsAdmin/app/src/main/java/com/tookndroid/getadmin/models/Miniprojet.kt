package com.tookndroid.getadmin.models

data class Miniprojet(
    val id : Int,
    val title : String,
    val theme : String,
    val description : String,
    val image : String,
    val vote_public : Int,
    val createdAt : String,
    val updatedAt : String,
    val concoursProjetId : Int
)
