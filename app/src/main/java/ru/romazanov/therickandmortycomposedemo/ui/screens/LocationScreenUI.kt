package ru.romazanov.therickandmortycomposedemo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavHostController
import ru.romazanov.therickandmortycomposedemo.MainViewModel
import ru.romazanov.therickandmortycomposedemo.ui.navigation.Screen
import ru.romazanov.therickandmortycomposedemo.ui.utils.*

@Composable
fun LocationScreenUI(
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
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                DefButtonBack {
                    navHostController.navigate(Screen.StartScreen.route)
                }
            }
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
            ) {
                val count = viewModel.locationList.size
                items(count) {
                    if (it >= viewModel.locationList.size - 1 && viewModel.location.info.next != null) {
                        val page = viewModel.location.info.next?.substringAfter('=')
                        viewModel.getLocationList(page!!)
                    }
                    LocationCard(result = viewModel.locationList[it])
                }
            }
        }
    }
}