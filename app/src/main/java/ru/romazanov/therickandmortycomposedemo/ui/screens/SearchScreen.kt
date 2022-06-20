package ru.romazanov.therickandmortycomposedemo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavHostController
import ru.romazanov.therickandmortycomposedemo.MainViewModel
import ru.romazanov.therickandmortycomposedemo.ui.utils.CharacterCard
import ru.romazanov.therickandmortycomposedemo.ui.utils.DefSearch
import ru.romazanov.therickandmortycomposedemo.ui.utils.DefTopBar

@Composable
fun SearchScreen(
    viewModel: MainViewModel,
    navHostController: NavHostController
) {
    val text = remember { mutableStateOf(TextFieldValue("")) }
    Scaffold(
        topBar = {
            DefTopBar(navHostController = navHostController)
        }
    ) {
        Column(
            Modifier.fillMaxSize()
        ) {
            DefSearch(state = text)
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    viewModel.getCharterListWithName(text.value.text)
                }) {
                Text("Найди меня")
            }
            LazyColumn(
                Modifier.fillMaxSize()
            ) {
                items(viewModel.characterSearch.results){ item ->
                    CharacterCard(result = item, navHostController = navHostController)
                }
            }
        }


    }
}