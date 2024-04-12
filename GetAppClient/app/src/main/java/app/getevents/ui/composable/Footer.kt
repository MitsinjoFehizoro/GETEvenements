package app.getevents.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import app.getevents.ui.MainViewModel
import app.getevents.ui.navigation.Route
import app.getevents.ui.state.UiStateFooterActive
import app.getevents.ui.theme.CustomColors
import app.getevents.ui.theme.acmeFont
import app.getevents.ui.theme.purWhite
import app.getevents.ui.theme.white

@Composable
fun Footer (
    navController: NavController,
    mainViewModel: MainViewModel = hiltViewModel()
){
    val uiStateFooterActive = mainViewModel.uiStateFooterActive
    
    Row(
        Modifier
            .fillMaxWidth()
            .height(90.dp)
            .background(
                color = CustomColors.primary,
                shape = RoundedCornerShape(topStart = 60.dp)
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 32.dp)
                .background(
                    color = CustomColors.onPrimary,
                    shape = RoundedCornerShape(8.dp)
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {

            FooterMenu(
                icon = Icons.Outlined.Home,
                isActive = uiStateFooterActive.value.home,
                st = "home",
                onClick = {
                    navController.navigate(Route.EventScreen.itineraire)
                }
            )
            FooterMenu(
                icon = Icons.Outlined.DateRange,
                isActive = uiStateFooterActive.value.event,
                st = "event",
                onClick = {
                    navController.navigate(Route.AttendScreen.itineraire)
                }
            )
            FooterMenu(
                icon = Icons.Outlined.Notifications,
                isActive = uiStateFooterActive.value.notice,
                st = "notice",
                onClick = { }
            )
            FooterMenu(
                icon = Icons.Outlined.Person,
                isActive = uiStateFooterActive.value.profile,
                st = "profile",
                onClick = { }
            )
        }
    }
}


@Composable
fun FooterMenu(
    icon : ImageVector,
    isActive : Boolean,
    st : String,
    onClick : ()->Unit
){
    val color = if (isActive) CustomColors.primary else Color.Transparent
    Box(
        Modifier
            .background(
                color = color,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        if (isActive){
            Text(
                text = st,
                fontFamily = acmeFont,
                fontSize = 12.sp,
                color = CustomColors.onWhite,
                modifier = Modifier
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            )
        } else {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = white,
                modifier = Modifier
                    .size(40.dp)
                    .padding(8.dp)
            )
        }

    }
}
