package com.tookndroid.getadmin.ui.navigation

sealed class Route (
    val itineraire : String
) {
    object ScreenHome : Route("screen_home")
    object ScreenEvent : Route("screen_event")
    object ScreenSignUp : Route("screen_signup")
    object ScreenEachEvent : Route("screen_eachevent")
    object ScreenAddModify : Route("screen_addmodify")

}