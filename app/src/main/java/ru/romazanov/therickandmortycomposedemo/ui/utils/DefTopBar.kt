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
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import ru.romazanov.therickandmortycomposedemo.R
import ru.romazanov.therickandmortycomposedemo.ui.navigation.Screen

@Composable
fun DefTopBar(
    navHostController: NavHostController
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.onPrimary
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = when(navHostController.currentDestination?.route) {
                    Screen.CharacterScreen.route -> stringResource(R.string.character_field)
                    Screen.EpisodeScreen.route -> stringResource(R.string.episode_field)
                    Screen.LocationScreen.route -> stringResource(R.string.location_field)
                    else -> stringResource(R.string.rick_and_morty_field)
                },
                style = MaterialTheme.typography.h4,
            )
        }
    }
}