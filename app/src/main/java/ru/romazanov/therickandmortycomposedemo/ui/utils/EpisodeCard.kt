package ru.romazanov.therickandmortycomposedemo.ui.utils


import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import ru.romazanov.therickandmortycomposedemo.data.models.episode.Result

@Composable
fun EpisodeCard(
    result: Result
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(100.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(5.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = result.name,
                style = MaterialTheme.typography.h5
            )
            Text(text = "Дата выпуска: ${result.air_date}")
            Text(text = result.episode)
            Text(text = result.episode)
        }

    }
}