package com.tookndroid.getadmin.models

data class EvenementsResponse(val data : List<Evenement>)

data class ConferencesResponse(val data : List<Conference>)

data class ReceptionsResponse(val data : List<Reception>)

data class ExcursionsResponse(val data : List<Excursion>)

data class ConcoursprojetsResponse(val data : List<Concoursprojet>)

/////////////////////////////////////////////////////

data class ConferenceResponse(val message : String, val data : Conference)

data class ReceptionResponse(val message : String, val data : Reception)

data class ExcursionResponse(val message : String, val data : Excursion)

data class ConcoursprojetReponse(val message : String, val data : Concoursprojet)