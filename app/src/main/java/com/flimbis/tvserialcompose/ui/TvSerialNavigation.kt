package com.flimbis.tvserialcompose.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.flimbis.tvserialcompose.ui.components.HomeScreen
import com.flimbis.tvserialcompose.ui.components.ShowScreen

@Composable
fun TvSerialNavigation(
    navController: NavHostController/* central api for nav component */,
    startDestination: String = "home",
    scaffoldPaddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable("home") {
            HomeScreen(
                onNavToShow = { id ->
                    navController.navigate("show?id=$id")
                },
                paddingValues = scaffoldPaddingValues
            )
        }

        composable(
            route = "show?id={id}",
            arguments = listOf(navArgument("id") { defaultValue = 1L })
        ) { navBackStackEntry /* extract available args */ ->
            ShowScreen(
                id = navBackStackEntry.arguments?.getLong("id"),
                paddingValues = scaffoldPaddingValues
            )
        }
    }
}
// NavGraph
// - specifies the composable destinations that can be navigated to
// NavController
// - https://developer.android.com/jetpack/compose/navigation
// - navController is central api for navigation component
// - navController is stateful and keeps track of the back stack of composables
// - each navController is associated to a NavHost which links the navController to the navGraph
// - create using; rememberNavController()
// NavHost
// - links navController to the navGraph
// - requires a navController and startDestination of the navGraph