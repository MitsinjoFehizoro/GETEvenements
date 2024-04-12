package com.tookndroid.getadmin.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.tookndroid.getadmin.R
import com.tookndroid.getadmin.component.Background
import com.tookndroid.getadmin.component.Buttoncomponent
import com.tookndroid.getadmin.component.DialogConfirmation
import com.tookndroid.getadmin.component.DialogShow
import com.tookndroid.getadmin.component.HeadingTextComponent
import com.tookndroid.getadmin.component.MyTextField
import com.tookndroid.getadmin.component.NormalTextComponent
import com.tookndroid.getadmin.component.PasswordTextField
import com.tookndroid.getadmin.ui.navigation.Route
import com.tookndroid.getadmin.ui.theme.Blue10
import com.tookndroid.getadmin.ui.theme.Blue100
import com.tookndroid.getadmin.ui.theme.Gray30

@Composable
fun ScreenSignUp(navController: NavHostController){
    Box(modifier = Modifier) {
        Background(modifier = Modifier.matchParentSize())
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .verticalScroll(rememberScrollState())
        ) {
            val shouldShowDialog = remember { mutableStateOf(false) }
            Column(modifier = Modifier.fillMaxHeight()) {
                Spacer(modifier = Modifier.height(30.dp))
                Image(
                    painter = painterResource(id = R.drawable.logoget),
                    contentDescription = "",
                    modifier = Modifier
                        .size(150.dp)
                        .padding(10.dp)
                        .padding(10.dp)
                        .align(Alignment.CenterHorizontally)
                )
//            NormalTextComponent(values = "Welcome")
                Row {
                    HeadingTextComponent(values1 = "GET " , values2 = "Event Admin")
                }
                Spacer(modifier = Modifier.height(40.dp))
                MyTextField(labelValue = "Prénom", icon = Icons.Default.Person)
                MyTextField(labelValue = "Nom", icon = Icons.Default.Person)
                MyTextField(
                    labelValue = "Numero d'inscription",
                    icon = Icons.Default.List
                )
                PasswordTextField(labelValue = "Mot de passe", txtValue = "")
                Spacer(modifier = Modifier.height(20.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                ) {
                    Buttoncomponent(
                        value = "Se connecter",
                        navController = navController,
                        route = Route.ScreenHome.itineraire
                    )
                }

                if (shouldShowDialog.value) {
                    DialogShow(
                        dialogText = "1 - Seuls les étudiants TCO - M1 peuvent accéder à cet application." +
                                " Si vous en faites partie, veuillez entrer les informations demandées." +
                                "\n\n2 - Si vous n'arrivez pas à vous connecter, vérifier bien les informations entrées",
                        shouldShowDialog = shouldShowDialog
                    )
                }
            }
            Text(
                text = "Besoin d'aide ?",
                style = TextStyle(fontWeight = FontWeight.Bold),
                color = Gray30,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .clickable { shouldShowDialog.value = true }
            )
        }
    }
}

//@Preview(showSystemUi = true)
//@Composable
//fun ScreenSignUpPreview(){
//    ScreenSignUp()
//}