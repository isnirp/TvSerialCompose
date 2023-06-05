package com.flimbis.tvserialcompose.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.LiveData
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.flimbis.tvserialcompose.model.Shows
import com.flimbis.tvserialcompose.ui.components.ShowsDetailScreen
import com.flimbis.tvserialcompose.ui.components.ShowsScreen

@Composable
fun TvSerialNavigation(
    navController: NavHostController,
    showsLiveData: LiveData<List<Shows>>,
    startDestination: String = "home"
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable("home") {
            ShowsScreen(
                showsLiveData = showsLiveData,
                { navController.navigate("showDetails") }
            )
        }

        composable("showDetails") {
            ShowsDetailScreen()
        }
    }
}