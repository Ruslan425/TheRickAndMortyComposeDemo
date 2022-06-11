package ru.romazanov.therickandmortycomposedemo.ui.utils


import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.ui.unit.dp
import ru.romazanov.therickandmortycomposedemo.data.models.location.Result


@Composable
fun LocationCard(
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
        Column() {
            Text(text = result.name)
            Text(text = result.type)
            Text(text = result.dimension)
        }
    }
}