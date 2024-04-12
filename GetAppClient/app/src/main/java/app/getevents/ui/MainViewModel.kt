package app.getevents.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.getevents.data.repository.GetRepository
import app.getevents.tools.Resultat
import app.getevents.tools.TYPE_AFFICHER
import app.getevents.ui.state.UiStateConcoursprojet
import app.getevents.ui.state.UiStateConference
import app.getevents.ui.state.UiStateEvent
import app.getevents.ui.state.UiStateFooterActive
import app.getevents.ui.state.UiStateMenuActive
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: GetRepository
) : ViewModel() {

    val uiStateEvent = mutableStateOf(UiStateEvent())
    val uiStateConference = mutableStateOf(UiStateConference())
    val uiStateConcoursprojet = mutableStateOf(UiStateConcoursprojet())

    val uiStateMenuActive = mutableStateOf(UiStateMenuActive())
    val uiStateFooterActive = mutableStateOf(UiStateFooterActive())

    init {

    }

    fun getEvent(){
        viewModelScope.launch {
            when(uiStateEvent.value.typeAfficher){
                TYPE_AFFICHER.EVENEMENT->{
                    repository.getEvenements().collect{resultat->
                        when (resultat){
                            is Resultat.Loading->{
                                uiStateEvent.value = UiStateEvent(isLoading = true)
                            }
                            is Resultat.Success->{
                                uiStateEvent.value = UiStateEvent(isLoading = false, data = resultat.data!!)
                            }
                            is Resultat.Error->{
                                uiStateEvent.value = UiStateEvent(isLoading = false, error = resultat.message)
                            }
                        }
                    }
                }
                TYPE_AFFICHER.CONFERENCE->{
                    repository.getConferences().collect{resultat->
                        when (resultat){
                            is Resultat.Loading->{
                                uiStateEvent.value = UiStateEvent(isLoading = true)
                            }
                            is Resultat.Success->{
                                uiStateEvent.value = UiStateEvent(isLoading = false, data = resultat.data!!)
                            }
                            is Resultat.Error->{
                                uiStateEvent.value = UiStateEvent(isLoading = false, error = resultat.message)
                            }
                        }
                        uiStateEvent.value = uiStateEvent.value.copy(
                            sousTitre = "Conferences"
                        )
                    }

                }
                TYPE_AFFICHER.CONCOURS_PROJET->{
                    repository.getConcoursProjets().collect{resultat->
                        when (resultat){
                            is Resultat.Loading->{
                                uiStateEvent.value = UiStateEvent(isLoading = true)
                            }
                            is Resultat.Success->{
                                uiStateEvent.value = UiStateEvent(isLoading = false, data = resultat.data!!)
                            }
                            is Resultat.Error->{
                                uiStateEvent.value = UiStateEvent(isLoading = false, error = resultat.message)
                            }
                        }
                        uiStateEvent.value = uiStateEvent.value.copy(
                            sousTitre = "Concours mini-projets"
                        )
                    }
                }
                TYPE_AFFICHER.EXCURSION->{
                    repository.getExcursions().collect{resultat->
                        when (resultat){
                            is Resultat.Loading->{
                                uiStateEvent.value = UiStateEvent(isLoading = true)
                            }
                            is Resultat.Success->{
                                uiStateEvent.value = UiStateEvent(isLoading = false, data = resultat.data!!)
                            }
                            is Resultat.Error->{
                                uiStateEvent.value = UiStateEvent(isLoading = false, error = resultat.message)
                            }
                        }
                        uiStateEvent.value = uiStateEvent.value.copy(
                            sousTitre = "Excursions"
                        )
                    }
                }
                TYPE_AFFICHER.RECEPTION->{
                    repository.getReceptions().collect{resultat->
                        when (resultat){
                            is Resultat.Loading->{
                                uiStateEvent.value = UiStateEvent(isLoading = true)
                            }
                            is Resultat.Success->{
                                uiStateEvent.value = UiStateEvent(isLoading = false, data = resultat.data!!)
                            }
                            is Resultat.Error->{
                                uiStateEvent.value = UiStateEvent(isLoading = false, error = resultat.message)
                            }
                        }
                        uiStateEvent.value = uiStateEvent.value.copy(
                            sousTitre = "Receptions"
                        )
                    }
                }
            }

        }
    }

    fun getConference(id : Int){
        viewModelScope.launch {
            repository.getConferenceByPk(id).collect{resultat->
                when(resultat){
                    is Resultat.Loading->{
                        uiStateConference.value = UiStateConference(isLoading = true)
                    }
                    is Resultat.Success->{
                        uiStateConference.value = UiStateConference(isLoading = false, data = resultat.data!!)
                    }
                    is Resultat.Error->{
                        uiStateConference.value = UiStateConference(isLoading = false, error = resultat.message)
                    }
                }

            }
        }
    }


    fun switchTypeAfficher(tp : TYPE_AFFICHER, state : UiStateMenuActive){
        uiStateMenuActive.value = state
        uiStateEvent.value = uiStateEvent.value.copy(
            typeAfficher = tp
        )
        getEvent()
    }
    fun switchFooterActive(state : UiStateFooterActive){
        uiStateFooterActive.value = state
    }
}