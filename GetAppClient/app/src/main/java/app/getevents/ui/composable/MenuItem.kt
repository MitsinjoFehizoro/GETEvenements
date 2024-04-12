package app.getevents.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.getevents.ui.theme.CustomColors
import app.getevents.ui.theme.acmeFont


@Composable
fun MenuItem(
    text: String,
    src: Int,
    isActive : Boolean,
    onClick : ()->Unit
){
    var color = CustomColors.onWhite
    if(isActive) color  = CustomColors.onPrimary

    Column(
        modifier = Modifier
            .size(100.dp)
            .border(
                width = 0.dp,
                color = color,
                shape = RoundedCornerShape(8.dp)
            )
            .background(
                color = CustomColors.onWhite,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(2.2f),
            contentAlignment = Alignment.Center
        ) {
            Box(
                Modifier
                    .background(
                        color = CustomColors.background,
                        shape = RoundedCornerShape(8.dp)
                    )
            ) {
                Image(
                    painter = painterResource(id = src) ,
                    contentDescription = null,
                    modifier = Modifier
                        .size(45.dp)
                        .padding(8.dp)
                )
            }
        }
        Box(
            Modifier
                .fillMaxWidth()
                .background(
                    color = CustomColors.secondary,
                    shape = RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomEnd = 8.dp,
                        bottomStart = 8.dp
                    )
                )
                .weight(0.8f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                fontFamily = acmeFont,
                softWrap = true,
                fontSize = 14.sp,
                color = CustomColors.onWhite,
                modifier = Modifier
            )
        }

    }
    Spacer(modifier = Modifier.width(16.dp))
}
