package app.getevents.ui.state

data class UiStateFooterActive(
    val home : Boolean = false,
    val event : Boolean = false,
    val notice : Boolean = false,
    val profile : Boolean = false,
)
