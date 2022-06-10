package ru.romazanov.therickandmortycomposedemo.ui.utils

import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable

@Composable
fun DefButtonBack(
    onClick:() -> Unit
) {
    Button(onClick = onClick) {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
        Text(text = "Назад")
    }
}