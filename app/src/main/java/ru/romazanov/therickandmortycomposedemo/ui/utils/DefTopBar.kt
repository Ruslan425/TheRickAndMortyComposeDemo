package ru.romazanov.therickandmortycomposedemo.ui.utils


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                if (navHostController.currentDestination?.route != Screen.StartScreen.route) {
                    IconButton(
                        onClick = {
                            navHostController.navigate(Screen.StartScreen.route)
                        }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back")
                    }
                }
            }
            Box(
                modifier = Modifier.weight(3f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = when (navHostController.currentDestination?.route) {
                        Screen.CharacterScreen.route -> stringResource(R.string.character_field)
                        Screen.EpisodeScreen.route -> stringResource(R.string.episode_field)
                        Screen.LocationScreen.route -> stringResource(R.string.location_field)
                        else -> stringResource(R.string.rick_and_morty_field)
                    },
                    style = MaterialTheme.typography.h4,
                )
            }

            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                IconButton(
                    onClick = { navHostController.navigate(Screen.SearchScreen.route) }
                ) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "search")
                }
            }


        }
    }
}