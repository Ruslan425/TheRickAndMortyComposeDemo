package ru.romazanov.therickandmortycomposedemo.data.models.episode

import ru.romazanov.therickandmortycomposedemo.data.models.general.Info

data class Episode(
    val info: Info = Info(),
    val results: List<Result> = listOf()
)