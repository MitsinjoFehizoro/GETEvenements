package app.getevents.ui.screen

import android.content.res.Configuration
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import app.getevents.R
import app.getevents.models.ConcoursProjet
import app.getevents.models.Conference
import app.getevents.models.Excursion
import app.getevents.models.Reception
import app.getevents.tools.FormatDate
import app.getevents.tools.TYPE_AFFICHER
import app.getevents.ui.MainViewModel
import app.getevents.ui.composable.CardEvenement
import app.getevents.ui.composable.ErrorComposable
import app.getevents.ui.composable.Loading
import app.getevents.ui.composable.MenuItem
import app.getevents.ui.navigation.Route
import app.getevents.ui.state.UiStateFooterActive
import app.getevents.ui.state.UiStateMenuActive
import app.getevents.ui.theme.CustomColors
import app.getevents.ui.theme.acmeFont

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EventScreen(
    navController: NavController,
    mainViewModel : MainViewModel = hiltViewModel()
){
    val uiStateEvent = mainViewModel.uiStateEvent.value
    val uiStateMenuActive = mainViewModel.uiStateMenuActive.value

    LaunchedEffect(Unit){
        mainViewModel.getEvent()
        mainViewModel.switchFooterActive(
            UiStateFooterActive(
                home = true,
                event = false,
                notice = false,
                profile = false
            )
        )
        mainViewModel.switchTypeAfficher(
            TYPE_AFFICHER.EVENEMENT,
            UiStateMenuActive(
                tous = true,
                conference = false,
                projet = false,
                excursion = false,
                reception = false
            )
        )
    }

    BaseScreen(
        title = "GET Events" ,
        isSearchBar = true,
        navController = navController
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(topEnd = 60.dp, bottomEnd = 60.dp))
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
        ) {
            Column( //Categorie
                Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Categories",
                    fontFamily = acmeFont,
                    fontSize = 12.sp,
                    color = CustomColors.onPrimary
                )
                Row(
                    Modifier
                        .padding(vertical = 8.dp)
                        .clip(shape = RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState())
                ) {
                    MenuItem(
                        text = "Evenements",
                        src = R.drawable.fireworks,
                        isActive = uiStateMenuActive.tous,
                        onClick =  {
                            mainViewModel.switchTypeAfficher(
                                TYPE_AFFICHER.EVENEMENT,
                                uiStateMenuActive.copy(
                                    tous = true,
                                    conference = false,
                                    projet = false,
                                    excursion = false,
                                    reception = false
                                )
                            )
                        }
                    )
                    MenuItem(
                        text = "Conferences",
                        src = R.drawable.conference,
                        isActive = uiStateMenuActive.conference,
                        onClick =  {
                            mainViewModel.switchTypeAfficher(
                                TYPE_AFFICHER.CONFERENCE,
                                uiStateMenuActive.copy(
                                    tous = false,
                                    conference = true,
                                    projet = false,
                                    excursion = false,
                                    reception = false
                                )
                            )
                        }
                    )
                    MenuItem(
                        text = "Mini-Projets",
                        src = R.drawable.clipboard,
                        isActive = uiStateMenuActive.projet,
                        onClick =  {
                            mainViewModel.switchTypeAfficher(
                                TYPE_AFFICHER.CONCOURS_PROJET,
                                uiStateMenuActive.copy(
                                    tous = false,
                                    conference = false,
                                    projet = true,
                                    excursion = false,
                                    reception = false
                                )
                            )
                        }
                    )
                    MenuItem(
                        text = "Excursions",
                        src = R.drawable.reforestation,
                        isActive = uiStateMenuActive.excursion,
                        onClick =  {
                            mainViewModel.switchTypeAfficher(
                                TYPE_AFFICHER.EXCURSION,
                                uiStateMenuActive.copy(
                                    tous = false,
                                    conference = false,
                                    projet = false,
                                    excursion = true,
                                    reception = false
                                )
                            )
                        }
                    )
//                    MenuItem(text = "Sport et loisir", src = R.drawable.football,onClick =  {mainViewModel.switchTypeAfficher(TYPE_AFFICHER.CONFERENCE)})
                    MenuItem(
                        text = "Receptions",
                        src = R.drawable.fireworks,
                        isActive = uiStateMenuActive.reception,
                        onClick =  {
                            mainViewModel.switchTypeAfficher(
                                TYPE_AFFICHER.RECEPTION,
                                uiStateMenuActive.copy(
                                    tous = false,
                                    conference = false,
                                    projet = false,
                                    excursion = false,
                                    reception = true
                                )
                            )
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Column(
                Modifier
                    .fillMaxSize()
            ) {

                SousTitre(sousTitre = uiStateEvent.sousTitre)

                Column(
                    Modifier
                        .padding(top = 8.dp)
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .clip(RoundedCornerShape(8.dp))
                ) {
                    if (uiStateEvent.isLoading){
                        Loading(280)
                    } else if(!uiStateEvent.error.isNullOrEmpty()){
                        ErrorComposable(uiStateEvent.error.toString(), 280)
                    } else {

                       uiStateEvent.data.forEach{data->
                           when(data){
                               is Conference->{
                                   CardEvenement(title = data.title, date = FormatDate(data.date) , lieu = data.lieu, url = data.url,  onClick = { navController.navigate("${Route.ConferenceScreen.itineraire}/${data.id}") } )
                               }
                               is ConcoursProjet->{
                                   CardEvenement(title = data.title, date = FormatDate(data.date) , lieu = data.lieu, url = data.url,  onClick = { navController.navigate("${Route.ConferenceScreen.itineraire}/${data.id}") } )
                               }
                               is Excursion->{
                                   CardEvenement(title = data.title, date = FormatDate(data.date) , lieu = data.lieu, url = data.url, onClick = { navController.navigate("${Route.ConferenceScreen.itineraire}/${data.id}") } )
                               }
                               is Reception->{
                                   CardEvenement(title = data.title, date = FormatDate(data.date) , lieu = data.lieu, url = data.url, onClick = { navController.navigate("${Route.ConferenceScreen.itineraire}/${data.id}") } )
                               }
                           }
                       }
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
    }
}


@Composable
fun SousTitre(sousTitre : String){
    Text(
        text = sousTitre,
        fontFamily = acmeFont,
        fontSize = 12.sp,
        color = CustomColors.onPrimary
    )
}

@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun EventScreenPreview(){
//    EventScreen()
}
