package app.getevents.tools

sealed class Resultat<T> (
    val data : T? = null,
    val message : String? = null
){
    class Loading<T>() : Resultat<T>()
    class Success<T>(data: T) : Resultat<T>(data = data)
    class Error<T>(message: String?) : Resultat<T>(message = message)
}