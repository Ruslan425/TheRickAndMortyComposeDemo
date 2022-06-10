package ru.romazanov.therickandmortycomposedemo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.romazanov.therickandmortycomposedemo.ui.screens.CharacterScreenUI
import ru.romazanov.therickandmortycomposedemo.ui.screens.EpisodeScreenUI
import ru.romazanov.therickandmortycomposedemo.ui.screens.LocationScreenUI
import ru.romazanov.therickandmortycomposedemo.ui.screens.StartScreenUI


@Composable
fun Navigation(navHostController: NavHostController) {

    NavHost(navController = navHostController, startDestination = Screen.StartScreen.route) {
        composable(Screen.StartScreen.route) {
            StartScreenUI(navHostController = navHostController)
        }
        composable(Screen.CharacterScreen.route) {
            CharacterScreenUI(navHostController = navHostController)
        }
        composable(Screen.LocationScreen.route) {
            LocationScreenUI(navHostController = navHostController)
        }
        composable(Screen.EpisodeScreen.route) {
            EpisodeScreenUI(navHostController = navHostController)
        }
    }
}
