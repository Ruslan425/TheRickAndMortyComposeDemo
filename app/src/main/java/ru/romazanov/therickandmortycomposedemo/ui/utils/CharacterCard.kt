package ru.romazanov.therickandmortycomposedemo.ui.utils


import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import ru.romazanov.therickandmortycomposedemo.data.models.characrer.Result
import java.net.URLDecoder

@Composable
fun CharacterCard(
    result: Result
) {

    Card(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()
        .height(100.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(5.dp)
    ) {
        Row(modifier = Modifier
            .padding(4.dp)
            .fillMaxHeight()
            .width(100.dp)
        ) {
            Image(
                painter = rememberImagePainter(
                    data = URLDecoder.decode(result.image)
                ),
                contentDescription = "Avatar",
                modifier = Modifier.padding(4.dp)
            )
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = "Имя: ${result.name}")
                Text(text = "Гендр: ${result.gender}")
                Text(text = "Tип: ${result.type.ifEmpty { "Неизвестен" }}")
                Text(text = "Расположение ${result.location.name}")
            }
        }
    }
}