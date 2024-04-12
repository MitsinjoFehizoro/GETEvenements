package app.getevents.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import app.getevents.ui.composable.BaseStyle
import app.getevents.ui.composable.Footer
import app.getevents.ui.composable.Header
import app.getevents.ui.composable.SearchBar
import app.getevents.ui.theme.CustomColors

@Composable
fun BaseScreen(
    title : String,
    isSearchBar : Boolean,
    navController: NavController,
    content : @Composable () -> Unit
){
    ConstraintLayout(
        Modifier.fillMaxSize()
    ) {
        BaseStyle()
        Column(
            Modifier
                .fillMaxSize()
        ) {

            Column(
                Modifier
                    .fillMaxWidth()
                    .background(
                        color = CustomColors.primary,
                        shape = RoundedCornerShape(bottomStart = 60.dp)
                    ),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Header(title, navController)
                if (isSearchBar){
                    SearchBar()
                }

            }

            Column(
                Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(
                        color = CustomColors.background,
                        shape = RoundedCornerShape(topEnd = 60.dp, bottomEnd = 60.dp)
                    )
            ) {//contenu dynamique
                content()
            }

            Footer(navController)

        }
    }
}

//@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
//@Composable
//fun BasePreview(){
//    BaseScreen("Get Events", true, content = { Column { } })
//}
