package com.tookndroid.getadmin.data.repository

import com.tookndroid.getadmin.tools.Resultat
import com.tookndroid.getadmin.data.api.GetApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class GetRepository @Inject constructor(
    private val api : GetApi
) {

    //GET
    suspend fun getEvenements() = flow {
        emit(Resultat.Loading())
        val evenements = api.getEvenements().body()?.data
        emit(Resultat.Success(evenements))
    }.catch { error->
        emit(Resultat.Error(error.message))
    }

    suspend fun getConferences() = flow {
        emit(Resultat.Loading())
        val conferences = api.getConferences().body()?.data
        emit(Resultat.Success(conferences))
    }.catch { error->
        emit(Resultat.Error(error.message))
    }

    suspend fun getReceptions() = flow {
        emit(Resultat.Loading())
        val programmes = api.getReceptions().body()?.data
        emit(Resultat.Success(programmes))
    }.catch { error->
        emit(Resultat.Error(error.message))
    }

    suspend fun getExcursions() = flow {
        emit(Resultat.Loading())
        val activites = api.getExcursions().body()?.data
        emit(Resultat.Success(activites))
    }.catch { error->
        emit(Resultat.Error(error.message))
    }

    suspend fun getConcoursprojets() = flow {
        emit(Resultat.Loading())
        val miniprojets = api.getConcoursprojets().body()?.data
        emit(Resultat.Success(miniprojets))
    }.catch { error->
        emit(Resultat.Error(error.message))
    }

    //SET
    suspend fun setConferences() = flow {
        emit(Resultat.Loading())
        val conference = api.setConferences().body()?.data
        conference?.date = "23092004"
        emit(Resultat.Success(conference))
    }.catch { error->
        emit(Resultat.Error(error.message))
    }
}