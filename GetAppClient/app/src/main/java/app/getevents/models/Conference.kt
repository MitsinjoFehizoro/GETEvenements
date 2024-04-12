package app.getevents.models

data class Conference(
    val id : Int,
    val title : String,
    val description : String,
    val url : String,
    val lieu : String,
    val date : String,
    val intervenant : String,
    val cible : Array<String>,
    val createdAt : String,
    val updatedAt : String
)