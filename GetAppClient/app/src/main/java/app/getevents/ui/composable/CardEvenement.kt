package app.getevents.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.getevents.R
import app.getevents.tools.imageUrl
import app.getevents.ui.theme.CustomColors
import app.getevents.ui.theme.acmeFont
import coil.request.ImageRequest
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun CardEvenement(
    title : String,
    date : String,
    lieu : String,
    url :String,
    onClick : ()->Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clickable { onClick() }
            .background(
                color = CustomColors.onWhite,
                shape = RoundedCornerShape(8.dp)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            Modifier
                .fillMaxHeight()
                .padding(8.dp)
                .width(100.dp)
        ) {


            Image(
                painter = imageUrl(url = url),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(8.dp))
            )
        }
        Column(
            Modifier
                .fillMaxHeight(0.85f)
                .fillMaxWidth(1f)
                .padding(start = 8.dp, end = 16.dp),
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
            Row (
                Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null,
                    tint = CustomColors.onPrimary,
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    text = lieu,
                    fontFamily = acmeFont,
                    fontSize = 12.sp,
                    color = CustomColors.onPrimary,
                    overflow = TextOverflow.Ellipsis,
                    softWrap = false
                )
            }
        }

    }
    Spacer(modifier = Modifier.height(8.dp))
}