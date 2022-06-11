package ru.romazanov.therickandmortycomposedemo.ui.utils


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import ru.romazanov.therickandmortycomposedemo.ui.navigation.Screen

@Composable
fun DefTopBar(
    navHostController: NavHostController
) {

    TopAppBar(
        backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = when(navHostController.currentDestination?.route) {
                    Screen.CharacterScreen.route -> "Персонажи"
                    Screen.EpisodeScreen.route -> "Эпизоды"
                    Screen.LocationScreen.route -> "Локации"
                    else -> "Рик и Морти"
                },
                style = MaterialTheme.typography.h4.copy(Color.Black),
            )
        }
    }
}