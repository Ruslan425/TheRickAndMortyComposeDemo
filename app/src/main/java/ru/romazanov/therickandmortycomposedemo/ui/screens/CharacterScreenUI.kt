package ru.romazanov.therickandmortycomposedemo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
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
import ru.romazanov.therickandmortycomposedemo.ui.utils.CharacterCard
import ru.romazanov.therickandmortycomposedemo.ui.utils.DefButtonBack
import ru.romazanov.therickandmortycomposedemo.ui.utils.DefSearch
import ru.romazanov.therickandmortycomposedemo.ui.utils.DefTopBar

@Composable
fun CharacterScreenUI(
    navHostController: NavHostController,
    viewModel: MainViewModel,
) {
    Scaffold(
        topBar = {
            DefTopBar(navHostController = navHostController)
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                DefButtonBack {
                    navHostController.navigate(Screen.StartScreen.route)
                }
            }
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
            ) {
                val count = viewModel.characterList.size
                items(count) {
                    if (it >= viewModel.characterList.size - 1 &&  viewModel.character.info.next != null) {
                        val page = viewModel.character.info.next?.substringAfter('=')
                        viewModel.getCharacterList(page!!)
                    }
                    CharacterCard(result = viewModel.characterList[it])
                }
            }
        }
    }
}

