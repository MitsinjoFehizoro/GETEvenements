package app.getevents.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.getevents.R
import app.getevents.ui.theme.CustomColors
import app.getevents.ui.theme.acmeFont

@Composable
fun TitleEvenement(
    title : String,
    date : String,
    image : Painter
){
    Box(
        Modifier
            .padding(end = 12.dp, top = 16.dp)
    ) {
        Row(
            Modifier
                .height(80.dp)
                .background(
                    color = CustomColors.onWhite,
                    shape = RoundedCornerShape(topEndPercent = 50, bottomEndPercent = 50)
                )
        ) {
            Column(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(vertical = 12.dp)
                    .padding(start = 16.dp),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = title,
                    fontFamily = acmeFont,
                    fontSize = 18.sp,
                    color = CustomColors.secondary,
                    overflow = TextOverflow.Ellipsis,
                    softWrap = false
                )
                Row (
                    Modifier
                        .fillMaxWidth(),

                    ) {
                    Row(
                        Modifier
                            .weight(0.5f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = null,
                            tint = CustomColors.onPrimary,
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = date,
                            fontFamily = acmeFont,
                            fontSize = 12.sp,
                            color = CustomColors.onPrimary,
                            overflow = TextOverflow.Ellipsis,
                            softWrap = false
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(50))
                    .padding(8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(50))
                ) {
                    Image(
                        painter = image,
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds
                    )
                }
            }
        }

    }
}