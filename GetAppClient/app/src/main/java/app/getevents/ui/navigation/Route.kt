package app.getevents.ui.navigation

sealed class Route (
    val itineraire : String
) {
    object HomeScreen : Route("home_screen")
    object EventScreen : Route("event_screen")
    object ConferenceScreen : Route("conference_screen")
    object AttendScreen : Route("attend_screen")
}