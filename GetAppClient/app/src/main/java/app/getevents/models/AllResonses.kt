package app.getevents.models

data class EvenementsResponse(val data : List<Evenement>)

data class ConferencesResponse(val data : List<Conference>)

data class ConferenceResponse(val data : Conference)

data class ConcoursProjetsResponse(val data : List<ConcoursProjet>)

data class ExcursionsResponse(val data : List<Excursion>)

data class ReceptionsResponse(val data : List<Reception>)