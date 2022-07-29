package ru.romazanov.therickandmortycomposedemo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.romazanov.therickandmortycomposedemo.MainViewModel
import ru.romazanov.therickandmortycomposedemo.R
import ru.romazanov.therickandmortycomposedemo.ui.utils.CharacterCard
import ru.romazanov.therickandmortycomposedemo.ui.utils.DefTopBar
import ru.romazanov.therickandmortycomposedemo.ui.utils.EpisodeCard
import ru.romazanov.therickandmortycomposedemo.ui.utils.LocationCard

@Composable
fun SearchScreen(
    viewModel: MainViewModel,
    navHostController: NavHostController
) {
    val focusManager = LocalFocusManager.current
    var text by remember { mutableStateOf(TextFieldValue("")) }

    var character by remember { mutableStateOf(false) }
    var episode by remember { mutableStateOf((false)) }
    var location by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            DefTopBar(navHostController = navHostController)
        }
    ) {
        Column(
            Modifier.fillMaxSize()
        ) {
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                placeholder = {
                    Text(
                        text = stringResource(R.string.search_field_text),
                    )
                },
                leadingIcon = {
                    Icon(
                        Icons.Filled.Search,
                        contentDescription = "Localized description"
                    )
                },
                trailingIcon = {
                    IconButton(onClick = {
                        text = TextFieldValue("")
                    }) {
                        Icon(imageVector = Icons.Default.Clear, contentDescription = "clear")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                singleLine = true,
                keyboardActions = KeyboardActions(
                    onDone = {
                        when {
                            character -> viewModel.getCharterListWithName(
                                mapOf(Pair("name", text.text)))
                            location -> viewModel.getLocationListWithName(
                                mapOf(
                                    Pair("name", text.text)))
                            episode -> viewModel.getEpisodeListWithName(
                                mapOf(
                                    Pair("name", text.text)))
                        }
                        focusManager.clearFocus()
                    }
                )
            )
            Row(
                modifier = Modifier
                    .padding(end = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = character, onClick = {
                        location = false
                        episode = false
                        character = !character
                    })
                    Text(text = stringResource(id = R.string.character_field))
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = episode, onClick = {
                        character = false
                        location = false
                        episode = !episode })
                    Text(text = stringResource(id = R.string.episode_field))
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = location, onClick = {
                        character = false
                        episode = false
                        location = !location })
                    Text(text = stringResource(id = R.string.location_field))
                }
            }
            when {
                character -> {
                    LazyColumn(
                        Modifier.fillMaxSize()
                    ) {
                        val count = viewModel.characterList.size
                        items(count) {
                            if (it >= viewModel.characterList.size - 1 && viewModel.character.info.next != null) {
                                val page = viewModel.character.info.next?.substringAfter('=')
                                viewModel.getCharacterList(
                                    mapOf(
                                        Pair("name", text.text),
                                        Pair("page", "$page")
                                    )
                                )
                            }
                            CharacterCard(
                                result = viewModel.characterList[it],
                                navHostController,
                                viewModel
                            )
                        }
                    }
                }
                episode -> {
                    LazyColumn(
                        Modifier.fillMaxSize()
                    ) {
                        val count = viewModel.episodeList.size
                        items(count) {
                            if (it >= viewModel.episodeList.size - 1 && viewModel.episode.info.next != null) {
                                val page = viewModel.episode.info.next?.substringAfter('=')
                                viewModel.getEpisodeList(
                                    mapOf(
                                        Pair("name", text.text),
                                        Pair("page", "$page")
                                    )
                                )
                            }
                            EpisodeCard(
                                result = viewModel.episodeList[it],
                                navHostController,
                                viewModel
                            )
                        }
                    }
                }
                location -> {
                    LazyColumn(
                        Modifier.fillMaxSize()
                    ) {
                        val count = viewModel.locationList.size
                        items(count) {
                            if (it >= viewModel.locationList.size - 1 && viewModel.location.info.next != null) {
                                val page = viewModel.location.info.next?.substringAfter('=')
                                viewModel.getLocationList(
                                    mapOf(
                                        Pair("name", text.text),
                                        Pair("page", "$page")
                                    )
                                )
                            }
                            LocationCard(
                                result = viewModel.locationList[it],
                                navHostController,
                                viewModel
                            )
                        }
                    }
                }
            }

        }
    }
}