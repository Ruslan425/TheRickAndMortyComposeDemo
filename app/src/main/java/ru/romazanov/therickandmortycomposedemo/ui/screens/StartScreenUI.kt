package ru.romazanov.therickandmortycomposedemo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.romazanov.therickandmortycomposedemo.R
import ru.romazanov.therickandmortycomposedemo.ui.navigation.Screen
import ru.romazanov.therickandmortycomposedemo.ui.utils.DefTopBar


@Composable
fun StartScreenUI(navHostController: NavHostController) {
    Scaffold(
        topBar = {
            DefTopBar(navHostController = navHostController)
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
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
                    tint = Color.Black,
                    modifier = Modifier.padding(end = 2.dp)
                )


                Text(
                    text = stringResource(R.string.character_field),
                    style = MaterialTheme.typography.h5,
                    color = Color.Black
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
                    tint = Color.Black,
                    modifier = Modifier.padding(end = 2.dp)
                )
                Text(
                    text = stringResource(R.string.location_field),
                    style = MaterialTheme.typography.h5,
                    color = Color.Black
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
                    contentDescription = "",
                    tint = Color.Black
                )
                Text(
                    text = stringResource(R.string.episode_field),
                    style = MaterialTheme.typography.h5,
                    color = Color.Black
                )
            }
        }
    }
}

