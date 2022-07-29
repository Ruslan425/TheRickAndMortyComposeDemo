package ru.romazanov.therickandmortycomposedemo.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import ru.romazanov.therickandmortycomposedemo.MainViewModel
import ru.romazanov.therickandmortycomposedemo.R
import ru.romazanov.therickandmortycomposedemo.data.Favorite
import java.net.URLDecoder

@Composable
fun CharsetsUnitScreen(
    viewModel: MainViewModel,
) {

    val unit = viewModel.characterUnit

    val unitToAdd = Favorite(id = unit.id.toString(), category = stringResource(R.string.character_field))

    Scaffold() {
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
                    text = stringResource(R.string.id_field) + unit.id.toString(),
                    style = MaterialTheme.typography.h4
                )
                Text(
                    text = stringResource(R.string.name_field) + unit.name,
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
                    Text(text = stringResource(R.string.add_favorite_button))
                } else {
                    Text(text = stringResource(R.string.delete_favorite_button))
                }
            }
        }
    }

}