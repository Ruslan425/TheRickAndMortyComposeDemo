package ru.romazanov.therickandmortycomposedemo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import ru.romazanov.therickandmortycomposedemo.MainViewModel
import ru.romazanov.therickandmortycomposedemo.ui.utils.CharacterCard
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
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            val count = viewModel.characterList.size
            items(count) {
                if (it >= viewModel.characterList.size - 1 && viewModel.character.info.next != null) {
                    val page = viewModel.character.info.next?.substringAfter('=')
                    viewModel.getCharacterList(page!!)
                }
                CharacterCard(result = viewModel.characterList[it], navHostController)
            }
        }
    }
}


