package ru.romazanov.therickandmortycomposedemo.data.models.location

import ru.romazanov.therickandmortycomposedemo.data.models.general.Info

data class Location(
    val info: Info = Info(),
    val results: List<Result> = listOf()
)