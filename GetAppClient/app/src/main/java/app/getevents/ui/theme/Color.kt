package app.getevents.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val blueLight = Color(0xFF4C63FE)
val blueDark = Color(0xFF4C63FE)

val greenLight = Color(0xFF6CE693)
val greenDark = Color(0xFFaaa2Da)

val onBlue = Color(0xFF7A8EFF)

val white = Color(0xFFEFF3FF)
val myDark = Color(0xFF2B2D30)

val dark = Color(0xFF18191A)
val purWhite = Color(0xFFFFFFFF)

val noir = Color(0xFF242526)

val grey = Color(0xFF787878)

object CustomColors {
    val primary : Color
        @Composable
        get() = if (isSystemInDarkTheme()) blueLight else blueLight

    val secondary : Color
        @Composable
        get() = if (isSystemInDarkTheme()) greenLight else greenLight

    val background : Color
        @Composable
        get() = if (isSystemInDarkTheme()) myDark else white

    val onBackground : Color
    @Composable
    get() = if (isSystemInDarkTheme()) white else grey

    val onDark : Color
    @Composable
    get() = if(isSystemInDarkTheme()) white else noir

    val onPrimary : Color
    @Composable
    get() = if (isSystemInDarkTheme()) onBlue else onBlue

    val onWhite : Color
        @Composable
        get() = if (isSystemInDarkTheme()) dark else purWhite

}