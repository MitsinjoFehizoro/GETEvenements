package app.getevents.data.api


import app.getevents.models.ConcoursProjetsResponse
import app.getevents.models.Conference
import app.getevents.models.ConferenceResponse
import app.getevents.models.ConferencesResponse
import app.getevents.models.EvenementsResponse
import app.getevents.models.ExcursionsResponse
import app.getevents.models.ReceptionsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GetApi {
    @GET("/get/conferences/")
    suspend fun getConferences () : Response<ConferencesResponse>

    @GET("/get/conferences/{id}")
    suspend fun getConferenceByPk(@Path("id") id : Int) : Response<ConferenceResponse>

    @GET("/get/concours-projets")
    suspend fun getConcoursProjets() : Response<ConcoursProjetsResponse>

    @GET("/get/excursions")
    suspend fun getExcursions() : Response<ExcursionsResponse>

    @GET("/get/receptions")
    suspend fun getReceptions() : Response<ReceptionsResponse>

}