package com.tookndroid.getadmin.ui.theme

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tookndroid.getadmin.data.repository.GetRepository
import com.tookndroid.getadmin.tools.Resultat
import com.tookndroid.getadmin.tools.TYPE_AFFICHER
import com.tookndroid.getadmin.ui.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val repository: GetRepository,
) : ViewModel() {

    var uiState = mutableStateOf(UiState())

    init {
        getEvent()
    }

    //asina condition when
    fun getEvent() {
        viewModelScope.launch {
            when (uiState.value.typeAfficher) {
                TYPE_AFFICHER.EVENEMENT -> {
                    repository.getEvenements().collect { resultat ->
                        when (resultat) {
                            is Resultat.Loading -> {
                                uiState.value = UiState(isLoading = true)
                            }

                            is Resultat.Success -> {
                                uiState.value = UiState(isLoading = false, data = resultat.data!!)
                            }

                            is Resultat.Error -> {
                                uiState.value = UiState(isLoading = false, error = resultat.message)
                            }
                        }
                    }
                }

                TYPE_AFFICHER.CONFERENCE -> {
                    repository.getConferences().collect { resultat ->
                        when (resultat) {
                            is Resultat.Loading -> {
                                uiState.value = UiState(isLoading = true)
                            }

                            is Resultat.Success -> {
                                uiState.value = UiState(isLoading = false, data = resultat.data!!)
                            }

                            is Resultat.Error -> {
                                uiState.value = UiState(isLoading = false, error = resultat.message)
                            }
                        }
                    }

                }

                TYPE_AFFICHER.RECEPTION -> {
                    repository.getReceptions().collect { resultat ->
                        when (resultat) {
                            is Resultat.Loading -> {
                                uiState.value = UiState(isLoading = true)
                            }

                            is Resultat.Success -> {
                                uiState.value = UiState(isLoading = false, data = resultat.data!!)
                            }

                            is Resultat.Error -> {
                                uiState.value = UiState(isLoading = false, error = resultat.message)
                            }
                        }
                    }
                }

                TYPE_AFFICHER.EXCURSION -> {
                    repository.getExcursions().collect { resultat ->
                        when (resultat) {
                            is Resultat.Loading -> {
                                uiState.value = UiState(isLoading = true)
                            }

                            is Resultat.Success -> {
                                uiState.value = UiState(isLoading = false, data = resultat.data!!)
                            }

                            is Resultat.Error -> {
                                uiState.value = UiState(isLoading = false, error = resultat.message)
                            }
                        }
                    }
                }

                TYPE_AFFICHER.CONCOURSPROJET -> {
                    repository.getConcoursprojets().collect { resultat ->
                        when (resultat) {
                            is Resultat.Loading -> {
                                uiState.value = UiState(isLoading = true)
                            }

                            is Resultat.Success -> {
                                uiState.value = UiState(isLoading = false, data = resultat.data!!)
                            }

                            is Resultat.Error -> {
                                uiState.value = UiState(isLoading = false, error = resultat.message)
                            }
                        }
                    }
                }
            }

        }
    }

    fun setEvent() {
        viewModelScope.launch {

        }
    }
}