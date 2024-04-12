package app.getevents.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import app.getevents.tools.imageUrl
import app.getevents.ui.composable.BaseDetailEvenement
import app.getevents.ui.composable.DetailEvenement
import app.getevents.ui.composable.TitleEvenement

@Composable
fun ExcursionScreen(
    navController: NavController
){
    BaseScreen(
        title = "GET Excursion",
        isSearchBar = false,
        navController = navController
    ) {
        TitleEvenement(
            title = "Excursion et reboisement 2024",
            date = "Vendredi, 21 avril 2024",
            image = imageUrl(url = "dj")
        )
        BaseDetailEvenement {
            DetailEvenement(
                title = "Description :",
                description = "Solutions plus performantes et innovantes pour développer le monde de demain Valorisez vos données et adoptez l'IA en toute confiance dans vos applications métiers grâce à nos expertises et nos partenariats stratégiques"
            )
            DetailEvenement(title = "Quand ?", description = "Vendredi, 21 avril 2024")
            DetailEvenement(title = "Ou ?", description = "Camp penal Ambohidratrimo")
            DetailEvenement(title = "Participation :", description = "15000 Ariary")
        }

    }
}

//@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
//@Composable
//fun ExcursionScreenPreview(){
//    ExcursionScreen()
//}