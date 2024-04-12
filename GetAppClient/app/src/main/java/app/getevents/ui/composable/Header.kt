package app.getevents.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import app.getevents.ui.theme.acmeFont
import app.getevents.ui.theme.purWhite
import app.getevents.ui.theme.white


@Composable
fun Header (
    title : String,
    navController: NavController
){
    Row(
        Modifier
            .padding(vertical = 4.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = null, tint = white)
        }
        Text(
            text = title,
            fontFamily = acmeFont,
            fontSize = 22.sp,
            color = purWhite,
            softWrap = false,
            overflow = TextOverflow.Ellipsis
        )
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.MoreVert, contentDescription = null, tint = white)
        }
    }
    Spacer(modifier = Modifier.height(32.dp))
}