package app.getevents.models

data class Reception(
    val id : Int,
    val title : String,
    val description	: String,
    val url : String,
    val lieu : String,
    val date : String,
    val createdAt : String,
    val updatedAt : String,
    val participation : String,
    val programmes : Array<Programme>
)
