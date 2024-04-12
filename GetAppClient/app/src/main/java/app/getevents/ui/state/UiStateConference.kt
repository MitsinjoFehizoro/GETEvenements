package app.getevents.ui.state

import app.getevents.models.Conference

data class UiStateConference(
    var isLoading: Boolean = true,
    val data: Conference? = null,
    val error : String? = null
)
