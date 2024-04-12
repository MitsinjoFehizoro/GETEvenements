package app.getevents.ui.screen

import android.content.res.Configuration
import android.widget.ImageView
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import app.getevents.ui.theme.CustomColors
import app.getevents.R
import app.getevents.ui.composable.BaseStyle
import app.getevents.ui.composable.PrimaryButton
import app.getevents.ui.composable.SecondaryButton
import app.getevents.ui.navigation.Route
import app.getevents.ui.theme.acmeFont
import app.getevents.ui.theme.white


@Composable
fun HomeScreen(
    navController: NavController
){
    ConstraintLayout (
        Modifier
            .fillMaxSize()
    ) {
        val (button) = createRefs()

        BaseStyle()

        Column (
            Modifier
                .fillMaxSize()
        ) {

            Box(
                Modifier
                    .fillMaxWidth()
                    .weight(1.1f)
                    .background(
                        color = CustomColors.background,
                        shape = RoundedCornerShape(bottomEnd = 80.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    var src =  R.drawable.lightlogo
                    if (isSystemInDarkTheme()) src =R.drawable.darklogo

                    Image(
                        painter = painterResource(id = src),
                        contentDescription = null,
                        Modifier.size(250.dp)
                    )

                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "GET E",
                            fontFamily = acmeFont,
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            color = CustomColors.primary
                        )

                        Text(
                            text = "vents",
                            fontFamily = acmeFont,
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            color = CustomColors.onDark
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))

                }
            }
            Box(
                Modifier
                    .fillMaxWidth()
                    .weight(0.9f)
                    .background(
                        color = CustomColors.primary,
                        shape = RoundedCornerShape(topStart = 80.dp)
                    )
            ) {
                Column(
                    Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(
                        Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Text(
                            text = "Les evenements dans",
                            fontFamily = acmeFont,
                            fontSize = 22.sp,
                            color = white,
                            textAlign = TextAlign.Center,
                        )
                        Text(
                            text = "la mention Telecommunication",
                            fontFamily = acmeFont,
                            fontSize = 22.sp,
                            color = white,
                            textAlign = TextAlign.Center
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Column(
                        Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Text(
                            text = "Veuillez creer un compte et se connecter pour",
                            fontFamily = acmeFont,
                            fontSize = 14.sp,
                            color = white,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = "voir tous les evenements dans la mention TCO.",
                            fontFamily = acmeFont,
                            fontSize = 14.sp,
                            color = white,
                            textAlign = TextAlign.Center
                        )
                    }
                    Spacer(modifier = Modifier.height(32.dp))
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {

                        PrimaryButton(text = "SignUp")
                        Spacer(modifier = Modifier.width(16.dp))
                        SecondaryButton(text = "Login")

                    }
                }
            }
        }

        Box(
            Modifier.constrainAs(button){
                end.linkTo(parent.end)
            }
        ) {
            IconButton(onClick = {
                navController.navigate(Route.EventScreen.itineraire)
            }) {
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null, tint = CustomColors.primary)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreview(){
//    HomeScreen()
}
