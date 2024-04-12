package app.getevents.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.getevents.ui.theme.CustomColors
import app.getevents.ui.theme.acmeFont
import app.getevents.ui.theme.white

@Composable
fun SearchBar(){
    Column(
        Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Row (
            Modifier
                .fillMaxWidth()
                .padding(start = 38.dp, end = 32.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(35.dp)
                    .background(
                        color = CustomColors.onPrimary,
                        shape = RoundedCornerShape(32.dp)
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(16.dp))
                Icon(imageVector = Icons.Default.Search, contentDescription = null, tint = white)
                Text(
                    text = "  Recherche...",
                    fontFamily = acmeFont,
                    fontSize = 16.sp,
                    color = white
                )
            }
        }
        Spacer(modifier = Modifier.height(22.dp))
    }

}