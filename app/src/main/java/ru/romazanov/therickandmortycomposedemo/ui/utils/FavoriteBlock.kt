package ru.romazanov.therickandmortycomposedemo.ui.utils

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.romazanov.therickandmortycomposedemo.MainViewModel
import ru.romazanov.therickandmortycomposedemo.R
import ru.romazanov.therickandmortycomposedemo.ui.navigation.Screen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FavoriteBlock(
    navHostController: NavHostController,
    viewModel: MainViewModel
) {
    Text(
        text = "Избранное",
        modifier = Modifier.padding(8.dp),
        style = MaterialTheme.typography.h3
    )
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
    ) {
        items(viewModel.favorite) { item ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .size(80.dp, 80.dp),
                elevation = 4.dp,
                onClick = {
                    when (item.category) {
                        "Персонажи" -> navHostController.navigate(Screen.CharacterUnitScreen.route + "/${item.id}")
                        "Эпизоды" -> navHostController.navigate(Screen.EpisodeUnitScreen.route + "/${item.id}")
                        else -> navHostController.navigate(Screen.LocationUnitScreen.route + "/${item.id}")
                    }
                }
            ) {
                Column(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxSize()
                ) {
                    Text(text = item.category)
                    Text(text = stringResource(R.string.id_field) + item.id.toString())
                }
            }
        }
    }
}

