package app.getevents.models

data class MiniProjet(
    val id : Int,
    val title : String,
    val theme : String,
    val description : String,
    val url : String,
    val image : String,
    val vote_public : Int,
    val createdAt : String,
    val updatedAt : String,
    val ConcoursProjetId : Int
)
