package app.getevents.ui.screen

import android.content.res.Configuration
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import app.getevents.tools.FormatDateHeure
import app.getevents.tools.imageUrl
import app.getevents.ui.MainViewModel
import app.getevents.ui.composable.BaseDetailEvenement
import app.getevents.ui.composable.DetailEvenement
import app.getevents.ui.composable.ErrorComposable
import app.getevents.ui.composable.Loading
import app.getevents.ui.composable.TitleEvenement

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ConferenceScreen(
    id: Int,
    mainViewModel: MainViewModel = hiltViewModel(),
    navController: NavController
){

    val uiStateConference = mainViewModel.uiStateConference.value
    
    LaunchedEffect(Unit){
        mainViewModel.getConference(id)
    }

    BaseScreen(
        title = "GET Conference",
        isSearchBar = false,
        navController = navController,
    ) {
        if (uiStateConference.isLoading) {
            Loading(400)
        } else if (!uiStateConference.error.isNullOrEmpty()){
            ErrorComposable(error = uiStateConference.error, 400)
        } else {
            uiStateConference.data?.let {conference->
                TitleEvenement(
                    title = conference.title,
                    date = FormatDateHeure(conference.date),
                    image = imageUrl(url = conference.url)
                )
            }

            uiStateConference.data?.let {conference->
                BaseDetailEvenement {

                    DetailEvenement(
                        title = "Description :",
                        description = conference.description
                    )
                    DetailEvenement(
                        title = "Intervenant :",
                        description = conference.intervenant
                    )
                    DetailEvenement(
                        title = "Quand ?",
                        description = FormatDateHeure(conference.date)
                    )
                    DetailEvenement(
                        title = "Ou ?",
                        description = conference.lieu
                    )
                    DetailEvenement(
                        title = "Cibles : ",
                        description = conference.cible.joinToString(", ")
                    )
                }
            }
        }
    }
}



@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun ConferenceScreenPreview(){
//    ConferenceScreen()
}