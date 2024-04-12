package app.getevents.models

data class ConcoursProjet(
    val id : Int,
    val title : String,
    val lieu : String,
    val date : String,
    val description : String,
    val url : String,
    val createdAt : String,
    val updatedAt : String,
    val jurry : String,
    val miniprojets : Array<MiniProjet>
)
