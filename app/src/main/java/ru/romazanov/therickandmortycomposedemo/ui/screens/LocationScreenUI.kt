package ru.romazanov.therickandmortycomposedemo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import ru.romazanov.therickandmortycomposedemo.MainViewModel
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

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            val count = viewModel.locationList.size
            items(count) {
                if (it >= viewModel.locationList.size - 1 && viewModel.location.info.next != null) {
                    val page = viewModel.location.info.next?.substringAfter('=')
                    viewModel.getLocationList(page!!)
                }
                LocationCard(result = viewModel.locationList[it], navHostController)
            }
        }
    }
}
