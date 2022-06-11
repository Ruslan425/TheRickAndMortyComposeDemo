package ru.romazanov.therickandmortycomposedemo.data.models.characrer

import ru.romazanov.therickandmortycomposedemo.data.models.general.Info

data class Character(
    val info: Info = Info(),
    val results: List<Result> = listOf()
)