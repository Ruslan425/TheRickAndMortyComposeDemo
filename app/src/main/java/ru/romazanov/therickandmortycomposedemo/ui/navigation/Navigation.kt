package ru.romazanov.therickandmortycomposedemo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ru.romazanov.therickandmortycomposedemo.MainViewModel
import ru.romazanov.therickandmortycomposedemo.ui.screens.*


@Composable
fun Navigation(
    navHostController: NavHostController,
    viewModel: MainViewModel
) {
    NavHost(navController = navHostController, startDestination = Screen.StartScreen.route) {
        composable(Screen.StartScreen.route) {
            StartScreenUI(navHostController = navHostController, viewModel)
        }
        composable(Screen.CharacterScreen.route) {
            CharacterScreenUI(navHostController = navHostController, viewModel)
        }
        composable(Screen.LocationScreen.route) {
            LocationScreenUI(navHostController = navHostController, viewModel)
        }
        composable(Screen.EpisodeScreen.route) {
            EpisodeScreenUI(navHostController = navHostController, viewModel)
        }
        composable(Screen.CharacterUnitScreen.route ) {
            CharsetsUnitScreen( viewModel = viewModel)
        }
        composable(Screen.SearchScreen.route) {
            SearchScreen(viewModel = viewModel, navHostController = navHostController)
        }

        composable(Screen.EpisodeUnitScreen.route ) {
          EpisodeUnitScreen(viewModel = viewModel)
        }
        composable(Screen.LocationUnitScreen.route ) {
          LocationUnitScreen(viewModel = viewModel)
        }


    }
}
