package ru.romazanov.therickandmortycomposedemo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.romazanov.therickandmortycomposedemo.MainViewModel
import ru.romazanov.therickandmortycomposedemo.ui.navigation.Screen
import ru.romazanov.therickandmortycomposedemo.ui.utils.DefButtonBack
import ru.romazanov.therickandmortycomposedemo.ui.utils.DefSearch
import ru.romazanov.therickandmortycomposedemo.ui.utils.DefTopBar
import ru.romazanov.therickandmortycomposedemo.ui.utils.EpisodeCard

@Composable
fun EpisodeScreenUI(
    navHostController: NavHostController,
    viewModel: MainViewModel
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
        ) {
            Row(modifier = Modifier
                .padding(start = 8.dp)
                .fillMaxWidth()
            ) {
                DefButtonBack {
                    navHostController.navigate(Screen.StartScreen.route)
                }
            }
            DefSearch(state = textState)
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(viewModel.episodeListState.value.results) { item ->
                    EpisodeCard(result = item)
                }
            }

        }
    }

}