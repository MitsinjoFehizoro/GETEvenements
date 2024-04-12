package app.getevents.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import app.getevents.ui.theme.CustomColors
import app.getevents.ui.theme.acmeFont
import app.getevents.ui.theme.white

@Composable
fun BaseDetailEvenement(
    content : @Composable () -> Unit
){
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Box(
            Modifier
                .fillMaxHeight()
                .weight(1f)
                .background(
                    color = CustomColors.onWhite,
                    shape = RoundedCornerShape(8.dp)
                )
        ) {

            Column(
                Modifier
                    .fillMaxSize()
                    .padding(vertical = 22.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                content()
            }

        }
        Spacer(modifier = Modifier.height(4.dp))
        Box(
            Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(
                    color = CustomColors.onWhite,
                    shape = RoundedCornerShape(8.dp)
                )
        ) {

            Row(
                Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp, end = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Cliquer si vous assisterez.",
                    fontFamily = acmeFont,
                    fontSize = 12.sp,
                    color = CustomColors.onPrimary,
                    modifier = Modifier.weight(1f)
                )
                Box(
                    Modifier
                        .height(40.dp)
                        .width(90.dp)
                        .background(
                            color = CustomColors.secondary,
                            shape = RoundedCornerShape(8.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Assister",
                        fontFamily = acmeFont,
                        fontSize = 12.sp,
                        color = white,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}