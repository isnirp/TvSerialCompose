package com.flimbis.tvserialcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.flimbis.tvserialcompose.ui.TvSerialNavigation
import com.flimbis.tvserialcompose.ui.components.TvAppBar
import com.flimbis.tvserialcompose.ui.theme.TvSerialComposeTheme
import com.flimbis.tvserialcompose.ui.vm.ShowsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val viewModel = ViewModelProvider(this).get(ShowsViewModel::class.java)

        setContent {
            TvSerialComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TvApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TvApp(navController: NavHostController = rememberNavController()) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get name of current screen
    val currentScreen = getAppBarTitle(backStackEntry?.destination?.route ?: "home")

    Scaffold(topBar = {
        TvAppBar(
            currentScreen = currentScreen,
            canNavBack = navController.previousBackStackEntry != null,
            navigateUp = { navController.navigateUp() }
        )
    }) {
        val viewModel: ShowsViewModel = hiltViewModel()

        TvSerialNavigation(
            navController = navController,
            showsLiveData = viewModel.showsUiState,
            scaffoldPaddingValues = it
        )
    }
}

fun getAppBarTitle(route: String): String {
    return when (route) {
        "home" -> "TvSerial"
        else -> "TvShow"
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TvSerialComposeTheme/*Material design created for the project*/ {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
        }
    }
}


// Modifiers
// - allow you to change the composable's size, layout, appearance or add high-level interactions, such as making an element clickable.
// Material Design
// - Material Design is built around three pillars: Color, Typography, and Shape
// Scaffold
// - Scaffold helps assemble app's structure
// - Scaffold can contain; appbar, floatingActionButton