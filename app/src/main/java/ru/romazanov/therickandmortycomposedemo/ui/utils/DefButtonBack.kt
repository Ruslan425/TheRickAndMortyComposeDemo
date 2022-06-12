package ru.romazanov.therickandmortycomposedemo.ui.utils

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.romazanov.therickandmortycomposedemo.R

@Composable
fun DefButtonBack(
    onClick: () -> Unit
) {
    OutlinedButton(
        modifier = Modifier.padding(start = 4.dp),
        onClick = onClick
    ) {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
        Text(text = stringResource(R.string.back_button_text))
    }
}