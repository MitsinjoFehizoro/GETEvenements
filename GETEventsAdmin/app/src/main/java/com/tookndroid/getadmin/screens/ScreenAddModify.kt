package com.tookndroid.getadmin.screens

import android.os.Build
import android.telecom.Conference
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Abc
//import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Place
//import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.tookndroid.getadmin.component.Background
import com.tookndroid.getadmin.component.DescriptionTxtField
import com.tookndroid.getadmin.component.MyTextField
import com.tookndroid.getadmin.component.TopAddModify
import com.tookndroid.getadmin.models.Evenement

@RequiresApi(Build.VERSION_CODES.M)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenAddModify(event: Any, navController: NavHostController) {
    Scaffold(
        topBar = { TopAddModify(navController = navController) }
    ) {
        Box(modifier = Modifier) {
            Background(modifier = Modifier.matchParentSize())
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Column(modifier = Modifier.padding(it)) {
                    MyTextField(labelValue = "Titre", icon = Icons.Default.List)
                    MyTextField(labelValue = "Date", icon = Icons.Default.DateRange)
                    MyTextField(labelValue = "Heure", icon = Icons.Default.DateRange)
                    MyTextField(labelValue = "Lieu", icon = Icons.Default.Place)
                    DescriptionTxtField(labelValue = "Description", icon = Icons.Default.Menu)
                }
            }
        }
    }
}

//@Preview
//@Composable
//fun ScreenAddModifyPreview() {
//    ScreenAddModify()
//}