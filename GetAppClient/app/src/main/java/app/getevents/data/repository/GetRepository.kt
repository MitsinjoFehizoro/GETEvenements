package app.getevents.data.repository

import androidx.compose.runtime.mutableStateOf
import app.getevents.data.api.GetApi
import app.getevents.tools.Resultat
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class GetRepository @Inject constructor(
    private val api : GetApi
) {

    suspend fun getEvenements() = flow {
        emit(Resultat.Loading())
        val evenements = mutableListOf<Any>()

        val conferences = api.getConferences().body()?.data
        val excursions = api.getExcursions().body()?.data
        val receptions = api.getReceptions().body()?.data
        val concoursProjets = api.getConcoursProjets().body()?.data

        conferences?.forEach{
            evenements.add(it)
        }
        excursions?.forEach{
            evenements.add(it)
        }
        receptions?.forEach{
            evenements.add(it)
        }
        concoursProjets?.forEach {
            evenements.add(it)
        }

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

    suspend fun getConferenceByPk(id : Int) = flow {
        emit(Resultat.Loading())
        val conference = api.getConferenceByPk(id).body()?.data
        emit(Resultat.Success(conference))
    }.catch { error->
        emit(Resultat.Error(error.message))
    }

    suspend fun getConcoursProjets() = flow {
        emit(Resultat.Loading())
        val concoursProjets = api.getConcoursProjets().body()?.data
        emit(Resultat.Success(concoursProjets))
    }.catch { error->
        emit(Resultat.Error(error.message))
    }

    suspend fun getExcursions() = flow {
        emit(Resultat.Loading())
        val excursions = api.getExcursions().body()?.data
        emit(Resultat.Success(excursions))
    }.catch { error->
        emit(Resultat.Error(error.message))
    }

    suspend fun getReceptions() = flow {
        emit(Resultat.Loading())
        val receptions = api.getReceptions().body()?.data
        emit(Resultat.Success(receptions))
    }.catch { error->
        emit(Resultat.Error(error.message))
    }
}