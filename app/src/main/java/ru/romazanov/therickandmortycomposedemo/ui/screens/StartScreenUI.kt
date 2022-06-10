package ru.romazanov.therickandmortycomposedemo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import ru.romazanov.therickandmortycomposedemo.ui.navigation.Screen
import ru.romazanov.therickandmortycomposedemo.ui.utils.DefTopBar


@Composable
fun StartScreenUI(navHostController: NavHostController){
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
            OutlinedButton(onClick = {
                navHostController.navigate(Screen.CharacterScreen.route)
            }) {
                Text("Персонажи")
            }
            OutlinedButton(onClick = {
                navHostController.navigate(Screen.LocationScreen.route)
            }) {
                Text("Локации")
            }
            OutlinedButton(onClick = {
                navHostController.navigate(Screen.EpisodeScreen.route)
            }) {
                Text("Эпизоды")
            }
        }
    }
}