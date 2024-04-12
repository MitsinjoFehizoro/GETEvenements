package com.tookndroid.getadmin.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tookndroid.getadmin.R
import com.tookndroid.getadmin.component.Background
import com.tookndroid.getadmin.component.ElevatedCardFun
import com.tookndroid.getadmin.component.MyTopAppBar
import com.tookndroid.getadmin.ui.navigation.Route
import com.tookndroid.getadmin.ui.theme.Blue1
import com.tookndroid.getadmin.ui.theme.Blue10
import com.tookndroid.getadmin.ui.theme.Blue100
import com.tookndroid.getadmin.ui.theme.Blue1000

@Composable
fun ScreenHome(navController: NavHostController){
    Scaffold(
        topBar = { MyTopAppBar() }
    ) {
        Box(modifier = Modifier) {
            Background(modifier = Modifier.matchParentSize())
            Box(modifier = Modifier.padding(20.dp)) {
                Column(modifier = Modifier.padding(it)) {
                    ElevatedCardFun(
                        img = painterResource(id = R.drawable.categories),
                        titre = "Choisissez une catégorie",
                        modifier = Modifier
                            .weight(1F)
                            .padding(10.dp)
                            .clip(RoundedCornerShape(10))
                            .background(brush = Brush.linearGradient(listOf(Blue1, Blue10, Blue100, Blue1000)))
                            .fillMaxWidth()
                    )
                    Row(modifier = Modifier.weight(3F)) {
                        Column(modifier = Modifier.weight(1F)) {
                            ElevatedCardFun(
                                img = painterResource(id = R.drawable.conference),
                                titre = "Conférences",
                                modifier = Modifier
                                    .weight(2F)
                                    .padding(10.dp)
                                    .clip(RoundedCornerShape(10))
                                    .clickable {
                                        navController.navigate(
                                            Route.ScreenEvent
                                                .itineraire + "/${1}"
                                        )
                                    }
                            )
                            ElevatedCardFun(
                                img = painterResource(id = R.drawable.reception),
                                titre = "Réception",
                                modifier = Modifier
                                    .weight(1F)
                                    .padding(10.dp)
                                    .clip(RoundedCornerShape(10))
                                    .clickable {
                                        navController.navigate(
                                            Route.ScreenEvent
                                                .itineraire + "/${2}"
                                        )
                                    }
                            )
                        }
                        Column(modifier = Modifier.weight(1F)) {
                            ElevatedCardFun(
                                img = painterResource(id = R.drawable.excursion),
                                titre = "Excursion",
                                modifier = Modifier
                                    .weight(1F)
                                    .padding(10.dp)
                                    .clip(RoundedCornerShape(10))
                                    .clickable {
                                        navController.navigate(
                                            Route.ScreenEvent
                                                .itineraire + "/${3}"
                                        )
                                    }
                            )
                            ElevatedCardFun(
                                img = painterResource(id = R.drawable.miniprojet),
                                titre = "Concours projet",
                                modifier = Modifier
                                    .weight(2F)
                                    .padding(10.dp)
                                    .clip(RoundedCornerShape(10))
                                    .clickable {
                                        navController.navigate(
                                            Route.ScreenEvent
                                                .itineraire + "/${4}"
                                        )
                                    }
                            )
                        }
                    }
                }
            }
        }
    }
}
