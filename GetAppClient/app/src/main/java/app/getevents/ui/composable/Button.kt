package app.getevents.ui.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.getevents.ui.theme.CustomColors
import app.getevents.ui.theme.acmeFont
import app.getevents.ui.theme.white

@Composable
fun PrimaryButton(text : String){
    Box(
        Modifier
            .height(45.dp)
            .width(140.dp)
            .border(
                BorderStroke(1.dp, CustomColors.secondary),
                shape = RoundedCornerShape(8.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontFamily = acmeFont,
            fontSize = 18.sp,
            color = CustomColors.secondary,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun SecondaryButton(text : String){
    Box(
        Modifier
            .height(45.dp)
            .width(140.dp)
            .background(
                color = CustomColors.secondary,
                shape = RoundedCornerShape(8.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontFamily = acmeFont,
            fontSize = 18.sp,
            color = white,
            textAlign = TextAlign.Center
        )
    }
}