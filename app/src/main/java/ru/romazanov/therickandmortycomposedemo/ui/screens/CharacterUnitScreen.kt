package ru.romazanov.therickandmortycomposedemo.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import ru.romazanov.therickandmortycomposedemo.MainViewModel
import java.net.URLDecoder

@Composable
fun CharsetsUnitScreen(
    id: Int,
    viewModel: MainViewModel
) {
    val unit = viewModel.characterList[id - 1]

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = rememberImagePainter(
                data = URLDecoder.decode(unit.image)
            ),
            contentDescription = "Avatar",
            modifier = Modifier
                .padding(4.dp)
                .size(200.dp, 200.dp)
        )
        Text(text = unit.name)
    }

}