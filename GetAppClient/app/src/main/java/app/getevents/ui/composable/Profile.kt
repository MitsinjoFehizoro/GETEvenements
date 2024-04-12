package app.getevents.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.getevents.R
import app.getevents.ui.theme.CustomColors
import app.getevents.ui.theme.acmeFont

@Composable
fun Profile(){
    Column {
        Text(
            text = "Bonjour, ",
            fontFamily = acmeFont,
            fontSize = 16.sp,
            color = CustomColors.onBackground
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Mitsinjo Fehizoro",
            fontFamily = acmeFont,
            fontSize = 18.sp,
            color = CustomColors.background
        )
    }
    Box(
        modifier = Modifier
            .size(60.dp)
            .clip(RoundedCornerShape(50))
            .background(color = CustomColors.background)
            .padding(3.dp)
    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(50))
        ) {
            Image(
                painter = painterResource(id = R.drawable.lightlogo),
                contentDescription = null,
            )
        }
    }
}