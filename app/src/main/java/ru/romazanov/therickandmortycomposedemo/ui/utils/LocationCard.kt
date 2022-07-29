package ru.romazanov.therickandmortycomposedemo.ui.utils


import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.romazanov.therickandmortycomposedemo.MainViewModel
import ru.romazanov.therickandmortycomposedemo.R
import ru.romazanov.therickandmortycomposedemo.data.models.location.Result
import ru.romazanov.therickandmortycomposedemo.ui.navigation.Screen


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LocationCard(
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

            viewModel.getLocationUnit(result.id.toString())
            navHostController.navigate(Screen.LocationUnitScreen.route)
        }
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(start = 4.dp)
        ) {
            Text(
                text = result.name,
                style = MaterialTheme.typography.h5
            )
            Text(text = stringResource(R.string.default_field_type) + ": " + result.type)
            Text(text = stringResource(R.string.location_field_dimension) + ": " + result.dimension.ifEmpty {
                stringResource(
                    R.string.default_unknown
                )
            })
        }
    }
}