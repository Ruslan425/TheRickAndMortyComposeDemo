package ru.romazanov.therickandmortycomposedemo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavHostController
import ru.romazanov.therickandmortycomposedemo.ui.navigation.Screen
import ru.romazanov.therickandmortycomposedemo.ui.utils.DefButtonBack
import ru.romazanov.therickandmortycomposedemo.ui.utils.DefSearch
import ru.romazanov.therickandmortycomposedemo.ui.utils.DefTopBar

@Composable
fun EpisodeScreenUI(
    navHostController: NavHostController
) {

    val textState = remember { mutableStateOf(TextFieldValue("")) }
    Scaffold(
        topBar = {
            DefTopBar(navHostController = navHostController)
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            Row(modifier = Modifier.fillMaxWidth()) {
                DefButtonBack {
                    navHostController.navigate(Screen.StartScreen.route)
                }
            }

            DefSearch(state = textState)

            Text("Эпизоды")
        }
    }

}