package ru.romazanov.therickandmortycomposedemo.ui.navigation

sealed class Screen(val route: String) {
    object StartScreen: Screen(route = "star_screen")
    object CharacterScreen: Screen(route = "character_screen")
    object LocationScreen: Screen(route = "location_screen")
    object EpisodeScreen: Screen(route = "episode_screen")
    object CharacterUnitScreen: Screen(route = "character_unit_screen")
    object EpisodeUnitScreen: Screen(route = "episode_unit_screen")
    object LocationUnitScreen : Screen(route = "location_unit_screen")
    object SearchScreen: Screen(route = "search_screen")
}
