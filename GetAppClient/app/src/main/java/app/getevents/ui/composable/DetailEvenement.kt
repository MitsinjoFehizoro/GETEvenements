package app.getevents.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.getevents.ui.theme.CustomColors
import app.getevents.ui.theme.acmeFont

@Composable
fun DetailEvenement(
    title : String,
    description :String
){
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 22.dp)
    ) {
        Text(
            text = title,
            fontFamily = acmeFont,
            fontSize = 14.sp,
            color = CustomColors.onPrimary,
        )
        Text(
            text = description,
            fontFamily = acmeFont,
            fontSize = 12.sp,
            lineHeight = 18.sp,
            color = CustomColors.onBackground,
        )
    }
    Spacer(modifier = Modifier.height(16.dp))
}