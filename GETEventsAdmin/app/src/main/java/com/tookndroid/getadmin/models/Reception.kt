package com.tookndroid.getadmin.models

data class Reception(
    var id : Int,
    var title : String,
    var lieu : String,
    var date : String,
    var description : String,
    var participation : Int,
    var createdAt : String,
    var upadatedAt : String,
    var evenementId : Int,
    var programmes : List<Programme>

)