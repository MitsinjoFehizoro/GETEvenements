package app.getevents.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import app.getevents.ui.screen.AttendScreen
import app.getevents.ui.screen.ConferenceScreen
import app.getevents.ui.screen.EventScreen
import app.getevents.ui.screen.HomeScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Route.HomeScreen.itineraire){
        composable(route = Route.HomeScreen.itineraire){
            HomeScreen(navController)
        }

        composable(route = Route.EventScreen.itineraire){
            EventScreen(navController)
        }

        composable(
            route = "${Route.ConferenceScreen.itineraire}/{id}",
            arguments = listOf(
                navArgument("id"){
                    type = NavType.IntType
                }
            )
        ){
            ConferenceScreen(id = it.arguments?.getInt("id")!!, navController = navController)
        }

        composable(route = Route.AttendScreen.itineraire){
            AttendScreen(navController)
        }

    }
}