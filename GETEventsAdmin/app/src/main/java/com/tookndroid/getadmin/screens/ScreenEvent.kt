package com.tookndroid.getadmin.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.tookndroid.getadmin.component.Background
import com.tookndroid.getadmin.component.ButtonSheet
import com.tookndroid.getadmin.component.DialogConfirmation
import com.tookndroid.getadmin.component.DisplayEventList
import com.tookndroid.getadmin.component.MyFloattingButton
import com.tookndroid.getadmin.component.MyTopAppBar
import com.tookndroid.getadmin.component.SearchBar
import com.tookndroid.getadmin.component.TopEvent
import com.tookndroid.getadmin.tools.TYPE_AFFICHER
import com.tookndroid.getadmin.ui.navigation.Route
import com.tookndroid.getadmin.ui.theme.MainViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ScreenEvent( mainViewModel : MainViewModel, selectionnedItem : Int?, navController :
NavHostController
) {
    var titleCategory : String = ""
        when(selectionnedItem) {
            1 -> {
                mainViewModel.uiState.value.typeAfficher =TYPE_AFFICHER.CONFERENCE
                titleCategory = "Conférences"
            }
            2 -> {
                mainViewModel.uiState.value.typeAfficher =TYPE_AFFICHER.RECEPTION
                titleCategory = "Réception"
            }
            3 -> {
                mainViewModel.uiState.value.typeAfficher =TYPE_AFFICHER.EXCURSION
                titleCategory = "Excursion"
            }
            4 -> {
                mainViewModel.uiState.value.typeAfficher =TYPE_AFFICHER.CONCOURSPROJET
                titleCategory = "Concours projets"
            }

        }
    Scaffold(
        topBar = { TopEvent(titleCategory, navController) },
        floatingActionButton = {
            MyFloattingButton( navController) }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Background(modifier = Modifier.matchParentSize())
            Box(modifier = Modifier) {
                Column(modifier = Modifier.padding(it)) {
                    val sheetState = rememberModalBottomSheetState()
                    val scope = rememberCoroutineScope()
                    val showBottomSheet = remember { mutableStateOf(false) }

                    //ButtonSheet(value = "Ilay event tokony kitihina", onClickedFun = {showBottomSheet.value = true})
                    DisplayEventList(mainViewModel, navController)


                    if (showBottomSheet.value) {
                        ModalBottomSheet(
                            onDismissRequest = { showBottomSheet.value = false },
                            sheetState = sheetState
                        ) {
                            Surface {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.End
                                ) {
                                    IconButton(onClick = {
                                        scope.launch { sheetState.hide() }.invokeOnCompletion {
                                            if (!sheetState.isVisible) {
                                                showBottomSheet.value = false
                                            }
                                        }
                                        navController.navigate(Route.ScreenAddModify.itineraire)
                                    }) {
                                        Icon(
                                            imageVector = Icons.Filled.Edit,
                                            contentDescription = "Edit"
                                        )
                                    }

                                    val shouldShowDialog = remember { mutableStateOf(false) }
                                    if (shouldShowDialog.value) {
                                        DialogConfirmation(
                                            dialogTitle = "Confirmation",
                                            dialogText = "Voulez-vous vraiment supprimer cet évènement",
                                            shouldShowDialog = shouldShowDialog,
                                            navController = navController
                                        )
                                    }
                                    IconButton(
                                        onClick = { shouldShowDialog.value = true }) {
                                        Icon(
                                            imageVector = Icons.Filled.Delete,
                                            contentDescription = "Edit"
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
