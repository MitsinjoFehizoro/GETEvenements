package app.getevents.ui.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import app.getevents.models.ConcoursProjet
import app.getevents.models.Conference
import app.getevents.models.Excursion
import app.getevents.models.Reception
import app.getevents.tools.FormatDate
import app.getevents.ui.MainViewModel
import app.getevents.ui.composable.CardEvenement
import app.getevents.ui.composable.ErrorComposable
import app.getevents.ui.composable.Loading
import app.getevents.ui.navigation.Route
import app.getevents.ui.state.UiStateFooterActive
import app.getevents.ui.theme.CustomColors
import app.getevents.ui.theme.acmeFont

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AttendScreen(
    navController : NavController,
    mainViewModel : MainViewModel = hiltViewModel()
){
    val uiStateEvent = mainViewModel.uiStateEvent.value

    LaunchedEffect(Unit){
        mainViewModel.getEvent()
        mainViewModel.switchFooterActive(
            UiStateFooterActive(
                home = false,
                event = true,
                notice = false,
                profile = false
            )
        )
    }
    BaseScreen(
        title = "Get Events",
        isSearchBar = true,
        navController = navController,
    ) {

        Column(
            Modifier
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(topEnd = 60.dp, bottomEnd = 60.dp))
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
        ) {

            Row(
                Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Menu(title = "Tous", isActive = true, width = 40 )
                Menu(title = "Assites", isActive = false, width = 65)
            }

            Column(
                Modifier
                    .padding(top = 8.dp)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                if (uiStateEvent.isLoading){
                    Loading(400)
                } else if(!uiStateEvent.error.isNullOrEmpty()){
                    ErrorComposable(uiStateEvent.error.toString(), 400)
                } else {
        
                    uiStateEvent.data.forEach{data->
                        when(data){
                            is Conference ->{
                                CardEvenement(title = data.title, date = FormatDate(data.date) , lieu = data.lieu, url = data.url,  onClick = { navController.navigate("${Route.ConferenceScreen.itineraire}/${data.id}") } )
                            }
                            is ConcoursProjet ->{
                                CardEvenement(title = data.title, date = FormatDate(data.date) , lieu = data.lieu, url = data.url,  onClick = { navController.navigate("${Route.ConferenceScreen.itineraire}/${data.id}") } )
                            }
                            is Excursion ->{
                                CardEvenement(title = data.title, date = FormatDate(data.date) , lieu = data.lieu, url = data.url, onClick = { navController.navigate("${Route.ConferenceScreen.itineraire}/${data.id}") } )
                            }
                            is Reception ->{
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

@Composable
fun Menu(
    title : String,
    isActive : Boolean,
    width : Int,
){
    Column(
        Modifier
            .width(width.dp)
    ) {
        Text(
            text = title,
            fontFamily = acmeFont,
            fontSize = 12.sp,
            color = CustomColors.onPrimary,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )
        val color = if (isActive) CustomColors.onPrimary else Color.Transparent
        Box(
            Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(
                    color = color
                )
        ) {

        }
    }

}


//@Preview(showBackground = true, showSystemUi = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_NO)
//@Composable
//fun AttendscreenPreview(){
//    AttendScreen()
//}
