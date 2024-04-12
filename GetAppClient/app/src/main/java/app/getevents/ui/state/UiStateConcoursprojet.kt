package app.getevents.ui.state

import app.getevents.models.ConcoursProjet

data class UiStateConcoursprojet(
    var isLoading: Boolean = true,
    val data: List<ConcoursProjet> = emptyList(),
    val error : String? = null
)
