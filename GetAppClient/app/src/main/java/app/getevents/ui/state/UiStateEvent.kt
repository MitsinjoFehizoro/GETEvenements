package app.getevents.ui.state

import app.getevents.tools.TYPE_AFFICHER

data class UiStateEvent(
    val typeAfficher: TYPE_AFFICHER = TYPE_AFFICHER.EVENEMENT,
    val sousTitre: String = "Tous les evenements",
    val isLoading: Boolean = true,
    val error: String? = null,
    val data: List<Any?> = emptyList()
)
