package com.tookndroid.getadmin.component

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tookndroid.getadmin.R
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.tookndroid.getadmin.models.Activite
import com.tookndroid.getadmin.models.Concoursprojet
import com.tookndroid.getadmin.models.Conference
import com.tookndroid.getadmin.models.Evenement
import com.tookndroid.getadmin.models.Excursion
import com.tookndroid.getadmin.models.Miniprojet
import com.tookndroid.getadmin.models.Programme
import com.tookndroid.getadmin.models.Reception
import com.tookndroid.getadmin.screens.ScreenEachEvent
import com.tookndroid.getadmin.tools.TYPE_AFFICHER
import com.tookndroid.getadmin.ui.navigation.Route
import com.tookndroid.getadmin.ui.state.UiState
import com.tookndroid.getadmin.ui.theme.Blue10
import com.tookndroid.getadmin.ui.theme.Blue100
import com.tookndroid.getadmin.ui.theme.Blue500
import com.tookndroid.getadmin.ui.theme.Blue60
import com.tookndroid.getadmin.ui.theme.Blue80
import com.tookndroid.getadmin.ui.theme.Gray30
import com.tookndroid.getadmin.ui.theme.Gray50
import com.tookndroid.getadmin.ui.theme.Green100
import com.tookndroid.getadmin.ui.theme.MainViewModel
import com.tookndroid.getadmin.ui.theme.White10
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun NormalTextComponent(values: String) {
    Text(
        text = values,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.purple_500),
        textAlign = TextAlign.Center
    )
}

@Composable
fun HeadingTextComponent(values1: String, values2: String) {
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = values1,
            modifier = Modifier.heightIn(),
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Normal
            ),
            color = Green100,
            textAlign = TextAlign.Center
        )
        Text(
            text = values2,
            modifier = Modifier.heightIn(),
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Normal
            ),
            color = Gray30,
            textAlign = TextAlign.Center
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(labelValue: String, icon: ImageVector) {
    val textValue = remember {
        mutableStateOf("")
    }
    Row {
        Icon(
            imageVector = icon,
            contentDescription = "",
            modifier = Modifier.align(Alignment.CenterVertically),
            tint = White10
        )
        Spacer(modifier = Modifier.padding(5.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            label = { Text(text = labelValue) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Gray30,
                focusedLabelColor = Gray30,
                cursorColor = Gray30,
                containerColor = White10
            ),
            keyboardOptions = KeyboardOptions.Default,
            singleLine = true,
            value = textValue.value,
            onValueChange = {
                textValue.value = it
            },
//            leadingIcon = { Icon(imageVector = icon, contentDescription = "") }
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(labelValue: String, txtValue: String) {
    val password = remember {
        mutableStateOf(txtValue)
    }
    val passwordVisible = remember {
        mutableStateOf(false)
    }
    Row {
        Icon(
            imageVector = Icons.Default.Lock,
            contentDescription = "",
            modifier = Modifier.align(Alignment.CenterVertically),
            tint = White10
        )
        Spacer(modifier = Modifier.padding(5.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            label = { Text(text = labelValue) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Blue10,
                focusedLabelColor = Blue100,
                cursorColor = Blue10,
                containerColor = White10
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            value = password.value,
            onValueChange = {
                password.value = it
            },
            trailingIcon = {
                val iconImage = if (passwordVisible.value) {
                    Icons.Filled.Visibility
                } else {
                    Icons.Filled.VisibilityOff
                }

                val description = if (passwordVisible.value) {
                    "Hide password"
                } else {
                    "Show password"
                }

                IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                    androidx.compose.material3.Icon(
                        imageVector = iconImage,
                        contentDescription = description,
                        tint = Gray50
                    )
                }
            },
            visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()
        )
    }
}

@Composable
fun Buttoncomponent(value: String, navController: NavHostController, route: String) {
    Button(
        onClick = { navController.navigate(route) },
        modifier = Modifier.heightIn(45.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
    ) {
        Box(
            modifier = Modifier
                .heightIn(45.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(Blue80, Blue80)),
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(15.dp)
            )
        }
    }
}

//@Composable
//fun ClickableHelp(){
//    val txtHelp = "Besoin d'aide ?"
//
//    val anotatedString = buildAnnotatedString {
//        withStyle(style = SpanStyle(color = Blue100)){
//            pushStringAnnotation(tag = txtHelp, annotation = txtHelp)
//            append(txtHelp)
//        }
//    }
//
//    ClickableText(text = anotatedString, onClick = {offset ->
//        anotatedString.getStringAnnotations(offset,offset)
//            .firstOrNull()?.also { span ->
////                if(span.item)
//            }
//    })
//}

@Composable
fun ElevatedCardFun(img: Painter, titre: String, modifier: Modifier) {
    Surface(
        modifier = modifier,
        color = Blue500
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = img,
                contentDescription = null,
            )
            Text(
                text = titre,
                softWrap = false,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Composable
fun MyTopAppBar() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.logoget),
            contentDescription = null,
            alignment = Alignment.CenterStart,
            modifier = Modifier.padding(10.dp)
        )
        Box(
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            Text(
                text = "GET Events",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.align(Alignment.CenterStart),
                fontFamily = FontFamily.Monospace
            )
        }
        Row {
            Spacer(modifier = Modifier.weight(1F))
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .fillMaxWidth()
                    .weight(1F),
                horizontalAlignment = Alignment.End
            ) {
                Image(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "",
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Text(
                    text = "Tooky",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }

    }
}

@Composable
fun SearchBar() {
    var wordToSearch: String = ""
    Row {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Retour",
            modifier = Modifier.weight(1F)
        )
        OutlinedTextField(
            value = "Test",
            onValueChange = {},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = " Recherche"
                )
            },
            placeholder = { Text(text = "Rechercher un évènement") },
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .weight(4F)
                .fillMaxWidth()
                .height(50.dp)
        )
        Spacer(modifier = Modifier.weight(1F))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventItem(
    event: Any,
    sheetState: SheetState,
    scope: CoroutineScope,
    showBottomSheet: MutableState<Boolean>,
    navController: NavHostController,
    onClickedFun: () -> Unit,
    currentData: MutableState<Any>
) {
    var title : String = "Titre"
    var lieu : String = "Lieu"
    var date : String = "Date"
    var description : String = "Description"

    when(event) {
        is Conference -> {
            title = event.title
            lieu = event.lieu
            date = event.date
            description = event.date
        }

        is Reception -> {
            title = event.title
            lieu = event.lieu
            date = event.date
            description = event.date
        }

        is Excursion -> {
            title = event.title
            lieu = event.lieu
            date = event.date
            description = event.date
        }

        is Concoursprojet -> {
            title = event.title
            lieu = event.lieu
            date = event.date
            description = event.date
        }
    }
        Card(
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier
            .padding(10.dp)
            .wrapContentHeight()
            .fillMaxWidth()
            .clickable {
                onClickedFun()
                showBottomSheet.value = true
            }
    ) {

        Row(modifier = Modifier.padding(7.dp)) {
            Image(
                painter = painterResource(id = R.drawable.logoget),
                contentDescription = null,
                modifier = Modifier
                    .padding(5.dp)
                    .size(50.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                Text(
                    text = title,
                    softWrap = false,
                    overflow = TextOverflow.Ellipsis
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = null,
                        modifier = Modifier.size(15.dp)
                    )
                    Text(text = date)
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null,
                        modifier = Modifier.size(15.dp)
                    )
                    Text(text = lieu)
                }
            }
        }
    }
    if (showBottomSheet.value)
        MyModalSheet(
            sheetState = sheetState,
            scope = scope,
            showBottomSheet = showBottomSheet,
            navController = navController,
            event = currentData.value
        )
}


@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DisplayEventList(
    mainViewModel: MainViewModel,
    navController: NavHostController
) {
    //mainViewModel.getEvent()
    var uiState = mainViewModel.uiState.value
    var currentData: MutableState<Any> = remember {
        mutableStateOf(uiState.data)
    }

    Column(
        Modifier
            .padding(vertical = 8.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .clip(RoundedCornerShape(8.dp)),
        verticalArrangement = Arrangement.Center
    ) {
        if (uiState.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(text = "En attente des donnees")
        } else if (!uiState.error.isNullOrEmpty()) {
            Text(text = uiState.error.toString())
        } else {
            Column() {
                val sheetState = rememberModalBottomSheetState()
                val scope = rememberCoroutineScope()
                val showBottomSheet = remember { mutableStateOf(false) }

                when (uiState.typeAfficher) {
                    TYPE_AFFICHER.EVENEMENT -> uiState.data.forEach { data ->
                        if (data is Evenement) {
                            val formatDate =
                                DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", Locale.FRENCH)
                            val date = ZonedDateTime.parse(data.date).format(formatDate)
                            EventItem(
                                event = data,
                                sheetState = sheetState,
                                scope = scope,
                                showBottomSheet = showBottomSheet,
                                navController = navController,
                                onClickedFun = { currentData.value = data },
                                currentData = currentData
                            )
                        }
                    }

                    TYPE_AFFICHER.CONFERENCE -> uiState.data.forEach { data ->
                        if (data is Conference) {
                            val formatDate =
                                DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", Locale.FRENCH)
                            val date = ZonedDateTime.parse(data.date).format(formatDate)
                            EventItem(
                                event = data,
                                sheetState = sheetState,
                                scope = scope,
                                showBottomSheet = showBottomSheet,
                                navController = navController,
                                onClickedFun = { currentData.value = data },
                                currentData = currentData
                            )

                        }
                    }

                    TYPE_AFFICHER.RECEPTION -> uiState.data.forEach { data ->
                        if (data is Reception) {
                            val formatDate =
                                DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", Locale.FRENCH)
                            val date = ZonedDateTime.parse(data.date).format(formatDate)
                            EventItem(
                                event = data,
                                sheetState = sheetState,
                                scope = scope,
                                showBottomSheet = showBottomSheet,
                                navController = navController,
                                onClickedFun = { currentData.value = data },
                                currentData = currentData
                            )


                        }
                    }

                    TYPE_AFFICHER.EXCURSION -> uiState.data.forEach { data ->
                        if (data is Excursion) {
                            val formatDate =
                                DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", Locale.FRENCH)
                            val date = ZonedDateTime.parse(data.date).format(formatDate)
                            EventItem(
                                event = data,
                                sheetState = sheetState,
                                scope = scope,
                                showBottomSheet = showBottomSheet,
                                navController = navController,
                                onClickedFun = { currentData.value = data },
                                currentData = currentData
                            )

                        }
                    }

                    TYPE_AFFICHER.CONCOURSPROJET ->
                        uiState.data.forEach { data ->
                            if (data is Concoursprojet) {
                                val formatDate =
                                    DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", Locale.FRENCH)
                                val date = ZonedDateTime.parse(data.date).format(formatDate)
                                EventItem(
                                    event = data,
                                    sheetState = sheetState,
                                    scope = scope,
                                    showBottomSheet = showBottomSheet,
                                    navController = navController,
                                    onClickedFun = { currentData.value = data },
                                    currentData = currentData
                                )
                            }
                        }
                }
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopEvent(titleCategory : String, navController: NavHostController) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Blue60,
            titleContentColor = Color.White,
        ),
        title = { Text(text = titleCategory) },
        navigationIcon = {
            IconButton(onClick = {
                navController.navigate(Route.ScreenHome.itineraire)
            }) {
                androidx.compose.material3.Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyFloattingButton(navController: NavHostController) {
    ExtendedFloatingActionButton(
        text = { Text(text = "Ajouter") },
        containerColor = Blue60,
        contentColor = Color.White,
        icon = { Icon(imageVector = Icons.Filled.Add, contentDescription = "Bouton ajouter") },
//        containerColor = Color.LightGray,
//        contentColor = Color.White,
        onClick = { navController.navigate(Route.ScreenAddModify.itineraire+"/1/1") },
    )
}

@Composable
fun ButtonSheet(value: String, onClickedFun: () -> Unit) {
    Button(
        onClick = { onClickedFun() },
        modifier = Modifier
            .height(45.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
    ) {
        Box(
            modifier = Modifier
                .height(45.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(Blue10, Blue100)),
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

@Composable
fun DialogConfirmation(
    dialogTitle: String,
    dialogText: String,
    shouldShowDialog: MutableState<Boolean>,
    navController: NavHostController
) {
    if (shouldShowDialog.value) {
        AlertDialog(
            title = { Text(text = dialogTitle) },
            text = { Text(text = dialogText) },
            onDismissRequest = { shouldShowDialog.value = false },
            confirmButton = {
                TextButton(onClick = {
                    shouldShowDialog.value = false
                    navController.navigate(Route.ScreenEvent.itineraire+"/1")
                }) {
                    Text(text = "Confirmer")
                }
            },
            dismissButton = {
                TextButton(onClick = { shouldShowDialog.value = false }) {
                    Text(text = "Anuler")
                }
            }
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAddModify(navController: NavHostController) {
    val shouldShowDialog = remember { mutableStateOf(false) }
    if (shouldShowDialog.value) {
        DialogConfirmation(
            dialogTitle = "Confirmation",
            dialogText = "Enregistrer cet évènement ?",
            shouldShowDialog = shouldShowDialog,
            navController = navController
        )
    }
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Blue60,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(text = "")
        },
        navigationIcon = {
            IconButton(onClick = { navController.navigate(Route.ScreenEvent.itineraire+"/1") }) {
                androidx.compose.material3.Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Cancel"
                )
            }
        },
        actions = {
            ButtonSheet(
                value = "Enregistrer",
                onClickedFun = { shouldShowDialog.value = true })
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DescriptionTxtField(labelValue: String, icon: ImageVector) {
    val textValue = remember {
        mutableStateOf("")
    }
    Row {
        Icon(
            imageVector = icon,
            contentDescription = "",
            modifier = Modifier.align(Alignment.CenterVertically),
            tint = White10
        )
        Spacer(modifier = Modifier.padding(5.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            label = { Text(text = labelValue) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Blue10,
                focusedLabelColor = Blue100,
                cursorColor = Blue10,
                containerColor = White10
            ),
            keyboardOptions = KeyboardOptions.Default,
            value = textValue.value,
            onValueChange = {
                textValue.value = it
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyModalSheet(
    sheetState: SheetState,
    scope: CoroutineScope,
    showBottomSheet: MutableState<Boolean>,
    navController: NavHostController,
    event: Any
) {
    if (showBottomSheet.value) {
        var typeOfSelectionned : Int = 0
        var idOfSelectionned : Int = 0
        when(event) {
            is Conference -> {
                typeOfSelectionned = 1
                idOfSelectionned = event.id
            }
            is Reception -> {
                typeOfSelectionned = 2
                idOfSelectionned = event.id
            }
            is Excursion -> {
                typeOfSelectionned = 3
                idOfSelectionned = event.id
            }
            is Concoursprojet -> {
                typeOfSelectionned = 4
                idOfSelectionned = event.id
            }
        }


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
                        navController.navigate(Route.ScreenAddModify
                            .itineraire+"/${typeOfSelectionned}/${idOfSelectionned}")
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
            ScreenEachEvent(event)
        }
    }
}

@Composable
fun Background(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.bg),
        contentDescription = "background",
        contentScale = ContentScale.FillBounds,
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDialogDatePicker(showDialogDatePicker: MutableState<Boolean>) {
    val state = rememberDatePickerState(initialDisplayMode = DisplayMode.Input)
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        DatePickerDialog(
            onDismissRequest = {
                openDialog.value = false
                showDialogDatePicker.value = false
            },
            confirmButton = {
                TextButton(onClick = {
                    //miampy ilay maka ilay données
                    openDialog.value = false
                    showDialogDatePicker.value = false
                }) {
                    Text(text = "OK")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    openDialog.value = false
                    showDialogDatePicker.value = false
                }) {
                    Text(text = "Annuler")
                }
            }
        ) {
            DatePicker(state = state)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTimePicker(showDialogTimePicker: MutableState<Boolean>) {
    val state = rememberTimePickerState()
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {

        Card {
            TimePicker(state = state)
            Row(modifier = Modifier.align(Alignment.End)){
                TextButton(
                    onClick = {
                        openDialog.value = false
                        showDialogTimePicker.value = false },

                    ) {
                    Text(
                        text = "Fermer"
                    )
                }
                TextButton(
                    onClick = {
                        openDialog.value = false
                        showDialogTimePicker.value = false },
//                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(
                        text = "Annuler"
                    )
                }
            }

        }
    }
}
@Composable
fun DialogShow(
    dialogText: String,
    shouldShowDialog: MutableState<Boolean>,
) {
    if (shouldShowDialog.value) {
        Dialog(onDismissRequest = { shouldShowDialog.value = false }) {
            Card {
                Text(
                    text = dialogText,
                    modifier = Modifier.padding(15.dp)
                )
                TextButton(
                    onClick = { shouldShowDialog.value = false },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(
                        text = "Fermer"
                    )
                }
            }
        }
    }
}

