package ru.romazanov.therickandmortycomposedemo.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import ru.romazanov.therickandmortycomposedemo.MainViewModel
import ru.romazanov.therickandmortycomposedemo.data.Favorite
import java.net.URLDecoder

@Composable
fun CharsetsUnitScreen(
    id: Int,
    viewModel: MainViewModel,
) {

    val unit = viewModel.characterList[id - 1]
    val unitToAdd = Favorite(id = id, category = "Персонаж")
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Surface(
            shape = CircleShape,
            modifier = Modifier.size(200.dp)
        ) {
            Image(
                painter = rememberImagePainter(
                    data = URLDecoder.decode(unit.image)
                ),
                contentDescription = "Avatar",
                modifier = Modifier
            )
        }
        Column(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Id: " + unit.id.toString(),
                style = MaterialTheme.typography.h4
            )
            Text(
                text = "Имя: " + unit.name,
                style = MaterialTheme.typography.h4
            )
        }
        OutlinedButton(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .height(50.dp),
            onClick = {
                if (!viewModel.favorite.contains(unitToAdd)) {
                    viewModel.favorite += unitToAdd
                } else {
                    viewModel.favorite -= unitToAdd
                }
            }
        ) {
            if (!viewModel.favorite.contains(unitToAdd)) {
                Text(text = "Добавить в избранное")
            } else {
                Text(text = "Убрать из избранного")
            }
        }
    }
}