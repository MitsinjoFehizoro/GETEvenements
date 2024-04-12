package com.tookndroid.getadmin.data.api


import com.tookndroid.getadmin.models.ConcoursprojetsResponse
import com.tookndroid.getadmin.models.ConferenceResponse
import com.tookndroid.getadmin.models.ConferencesResponse
import com.tookndroid.getadmin.models.EvenementsResponse
import com.tookndroid.getadmin.models.ExcursionsResponse
import com.tookndroid.getadmin.models.ReceptionsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface GetApi {
    //GET
    @GET("/get/evenements/")
    suspend fun getEvenements () : Response<EvenementsResponse>

    @GET("/get/conferences/")
    suspend fun getConferences () : Response<ConferencesResponse>

    @GET("/get/receptions/")
    suspend fun getReceptions () : Response<ReceptionsResponse>

    @GET("/get/excursions/")
    suspend fun getExcursions () : Response<ExcursionsResponse>

    @GET("/get/concours-projets/")
    suspend fun getConcoursprojets () : Response<ConcoursprojetsResponse>


    //POST
    @POST("/get/conferences/")
    suspend fun setConferences () : Response<ConferenceResponse>

    @POST("/get/receptions")
    suspend fun setReceptions () : Response<ReceptionsResponse>

    @GET("/get/excursions/")
    suspend fun setExcursions () : Response<ExcursionsResponse>

    @GET("/get/concours-projets/")
    suspend fun setConcoursprojets () : Response<ConcoursprojetsResponse>

}
