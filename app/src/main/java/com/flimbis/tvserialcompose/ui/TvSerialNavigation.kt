package com.flimbis.tvserialcompose.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.LiveData
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.flimbis.tvserialcompose.model.Shows
import com.flimbis.tvserialcompose.ui.components.ShowDetailScreen
import com.flimbis.tvserialcompose.ui.components.ShowsScreen

@Composable
fun TvSerialNavigation(
    navController: NavHostController = rememberNavController(),
    startDestination: String = "home",
    showsLiveData: LiveData<List<Shows>>
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable("home") {
            ShowsScreen(
                showsLiveData = showsLiveData,
                onDetailsClick = { id ->
                    navController.navigate("showDetails/$id")
                }
            )
        }

        composable(
            route = "showDetails/{id}",
            arguments = listOf(navArgument("id") { type = NavType.LongType })
        ) { navBackStackEntry ->
            ShowDetailScreen(navBackStackEntry.arguments!!.getLong("id"))
        }
    }
}