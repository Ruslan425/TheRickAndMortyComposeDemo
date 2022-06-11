package ru.romazanov.therickandmortycomposedemo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
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
                    imageVector = Icons.Default.Face,
                    contentDescription = "",
                    tint = Color.Black)

                Text(
                    text = "Персонажи",
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
                    imageVector = Icons.Default.Place,
                    contentDescription = "",
                    tint = Color.Black
                )

                Text(
                    text = "Локации",
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
                    painter = painterResource(id = R.drawable.ic_baseline_dashboard_24),
                    contentDescription = "",
                    tint = Color.Black
                )
                Text(
                    text = "Эпизоды",
                    style = MaterialTheme.typography.h5,
                    color = Color.Black
                )
            }
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun Prew() {
    val nav = rememberNavController()
    StartScreenUI(navHostController = nav)
}

 */