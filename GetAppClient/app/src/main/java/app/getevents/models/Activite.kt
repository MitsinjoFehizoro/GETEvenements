package app.getevents.models

data class Activite(
    val id : Int,
    val title : String,
    val description : String,
    val createdAt : String,
    val updatedAt : String,
    val ExcursionId : Int
)
