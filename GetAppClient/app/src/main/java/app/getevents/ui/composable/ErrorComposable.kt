package app.getevents.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.getevents.R
import app.getevents.ui.theme.CustomColors
import app.getevents.ui.theme.acmeFont
import app.getevents.ui.theme.white

@Composable
fun ErrorComposable(error : String, height : Int){
    Column(
        Modifier
            .fillMaxWidth()
            .height(height.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.erreur500) , 
            contentDescription = "error",
            modifier = Modifier
                .size(120.dp)
        )
        Text(
            text = "Impossible de se connecter au serveur",
            fontFamily = acmeFont,
            fontSize = 14.sp,
            lineHeight = 16.sp,
            color = CustomColors.onBackground,
            textAlign = TextAlign.Center
        )

        Text(
            text = error,
            fontFamily = acmeFont,
            fontSize = 12.sp,
            color = CustomColors.onBackground,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            Modifier
                .height(35.dp)
                .width(140.dp)
                .background(
                    color = CustomColors.secondary,
                    shape = RoundedCornerShape(8.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Reessayer",
                fontFamily = acmeFont,
                fontSize = 16.sp,
                color = white,
                textAlign = TextAlign.Center
            )
        }
    }
}