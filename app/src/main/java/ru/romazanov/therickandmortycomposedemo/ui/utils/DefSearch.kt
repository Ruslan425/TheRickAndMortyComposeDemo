package ru.romazanov.therickandmortycomposedemo.ui.utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp


@Composable
fun DefSearch(
    state: MutableState<TextFieldValue>,
) {

    OutlinedTextField(
        value = state.value,
        onValueChange = { state.value = it },
        placeholder = {
            Text(
                text = "Поиск",
            )
        },
        leadingIcon = {
            Icon(
                Icons.Filled.Search,
                contentDescription = "Localized description"
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
        ,
        singleLine = true,
    )
}