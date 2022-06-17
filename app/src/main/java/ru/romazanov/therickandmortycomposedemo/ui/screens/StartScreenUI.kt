package ru.romazanov.therickandmortycomposedemo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import ru.romazanov.therickandmortycomposedemo.MainViewModel
import ru.romazanov.therickandmortycomposedemo.R
import ru.romazanov.therickandmortycomposedemo.ui.navigation.Screen
import ru.romazanov.therickandmortycomposedemo.ui.utils.DefTopBar
import ru.romazanov.therickandmortycomposedemo.ui.utils.FavoriteBlock


@Composable
fun StartScreenUI(
    navHostController: NavHostController,
    viewModel: MainViewModel
) {
    Scaffold(
        topBar = {
            DefTopBar(navHostController = navHostController)
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            OutlinedButton(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .height(70.dp),
                onClick = {
                    navHostController.navigate(Screen.CharacterScreen.route)
                }) {

                Icon(
                    painter = painterResource(id = R.drawable.ic_one),
                    contentDescription = "",
                    modifier = Modifier.padding(end = 2.dp)
                )

                Text(
                    text = stringResource(R.string.character_field),
                    style = MaterialTheme.typography.h5,
                )
            }
            OutlinedButton(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .height(70.dp),
                onClick = {
                    navHostController.navigate(Screen.LocationScreen.route)
                }) {

                Icon(
                    painter = painterResource(id = R.drawable.ic_three),
                    contentDescription = "",
                    modifier = Modifier.padding(end = 2.dp)
                )
                Text(
                    text = stringResource(R.string.location_field),
                    style = MaterialTheme.typography.h5,
                )
            }
            OutlinedButton(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .height(70.dp),
                onClick = {
                    navHostController.navigate(Screen.EpisodeScreen.route)
                }) {

                Icon(
                    painter = painterResource(id = R.drawable.ic_two),
                    contentDescription = ""
                )
                Text(
                    text = stringResource(R.string.episode_field),
                    style = MaterialTheme.typography.h5,
                )
            }
            if (viewModel.favorite.isNotEmpty()) {
                FavoriteBlock(navHostController = navHostController, viewModel = viewModel)
            } else {
                Text(
                    text = "Блок избранного скрыт, для открытия нужно добавить в избранное:)",
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}


