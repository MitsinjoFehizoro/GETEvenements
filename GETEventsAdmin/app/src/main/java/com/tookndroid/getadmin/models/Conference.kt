package com.tookndroid.getadmin.models

data class Conference(
    var id : Int,
    var title : String,
    var lieu : String,
    var description : String,
    var date : String,
    var intervenant : String,
    var cible : Array<String>,
    var createdAt : String,
    var updatedAt : String,
    var EvenementId : String
)