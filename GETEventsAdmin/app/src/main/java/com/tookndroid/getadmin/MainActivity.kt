package com.tookndroid.getadmin

import androidx.activity.compose.setContent
import com.tookndroid.getadmin.ui.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.tookndroid.getadmin.ui.navigation.Navigation
import com.tookndroid.getadmin.ui.theme.MainViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation(hiltViewModel(), rememberNavController())
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Navigation(hiltViewModel(), rememberNavController())
}