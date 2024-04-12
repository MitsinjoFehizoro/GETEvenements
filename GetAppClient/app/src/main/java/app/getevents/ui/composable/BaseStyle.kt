package app.getevents.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.getevents.ui.theme.CustomColors

@Composable
fun BaseStyle(){
    Row (
        Modifier.fillMaxSize()
    ){
        Box(
            Modifier
                .fillMaxHeight()
                .weight(1f)
                .background(color = CustomColors.background)
        ) {

        }
        Box(
            Modifier
                .fillMaxHeight()
                .weight(1f)
                .background(color = CustomColors.primary)
        ) {

        }
    }
}