package ru.romazanov.therickandmortycomposedemo.ui.utils


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import ru.romazanov.therickandmortycomposedemo.MainViewModel
import ru.romazanov.therickandmortycomposedemo.R
import ru.romazanov.therickandmortycomposedemo.data.models.characrer.Result
import ru.romazanov.therickandmortycomposedemo.ui.navigation.Screen
import java.net.URLDecoder

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CharacterCard(
    result: Result,
    navHostController: NavHostController,
    viewModel: MainViewModel
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(100.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(5.dp),
        onClick = {

            viewModel.getCharacterUnit(result.id.toString())

            navHostController.navigate(Screen.CharacterUnitScreen.route)
        }
    ) {
        Row(
            modifier = Modifier
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
                Text(
                    text = result.name,
                    style = MaterialTheme.typography.h5
                )
                Text(text = stringResource(R.string.character_field_gender) + ": " + result.gender)
                Text(text = stringResource(R.string.default_field_type) + ": " + result.type.ifEmpty {
                    stringResource(
                        R.string.default_unknown
                    )
                })
                Text(text = stringResource(R.string.character_field_location) + ": " + result.location.name)
            }
        }
    }
}

