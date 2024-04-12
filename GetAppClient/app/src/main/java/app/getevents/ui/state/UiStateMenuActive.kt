package app.getevents.ui.state

data class UiStateMenuActive(
    val tous : Boolean = false,
    val conference : Boolean = false,
    val projet : Boolean = false,
    val excursion : Boolean = false,
    val reception : Boolean = false
)
