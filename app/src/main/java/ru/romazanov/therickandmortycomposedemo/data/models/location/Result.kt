package ru.romazanov.therickandmortycomposedemo.data.models.location

data class Result(
    val created: String = "",
    val dimension: String = "",
    val id: Int = 0,
    val name: String = "",
    val residents: List<String> = listOf(),
    val type: String = "",
    val url: String = ""
)