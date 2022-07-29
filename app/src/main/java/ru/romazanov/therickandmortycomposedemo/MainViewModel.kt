package ru.romazanov.therickandmortycomposedemo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.romazanov.therickandmortycomposedemo.data.Favorite
import ru.romazanov.therickandmortycomposedemo.data.models.characrer.Character
import ru.romazanov.therickandmortycomposedemo.data.models.characrer.Result
import ru.romazanov.therickandmortycomposedemo.data.models.episode.Episode
import ru.romazanov.therickandmortycomposedemo.data.models.location.Location
import ru.romazanov.therickandmortycomposedemo.data.retrofit.ApiInterface
import ru.romazanov.therickandmortycomposedemo.utils.OPTIONS

class MainViewModel : ViewModel() {


    var favorite by mutableStateOf(listOf<Favorite>())

    var character by mutableStateOf(Character())
    var episode by mutableStateOf(Episode())
    var location by mutableStateOf(Location())

    var characterUnit by mutableStateOf(Result())
    var episodeUnit by mutableStateOf(ru.romazanov.therickandmortycomposedemo.data.models.episode.Result())
    var locationUnit by mutableStateOf(ru.romazanov.therickandmortycomposedemo.data.models.location.Result())

    private var errorMessage: String by mutableStateOf("")

    var characterList by mutableStateOf(listOf<Result>())
    var episodeList by mutableStateOf(listOf<ru.romazanov.therickandmortycomposedemo.data.models.episode.Result>())
    var locationList by mutableStateOf(listOf<ru.romazanov.therickandmortycomposedemo.data.models.location.Result>())

    private val apiInterface = ApiInterface.getInstance()

    fun getCharacterUnit(id: String) {
        viewModelScope.launch {
            try {
                val answer = apiInterface.getCharacterUnit(id)
                characterUnit = answer
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    fun getCharterListWithName(options: Map<String, String>) {
        viewModelScope.launch {
            try {
                val answer = apiInterface.getCharacterList(options)
                character = answer
                characterList = answer.results
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    fun getCharacterList(options: Map<String, String>) {
        viewModelScope.launch {
            try {
                val answer = apiInterface.getCharacterList(options)
                character = answer
                characterList += answer.results
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    fun getLocationList(options: Map<String, String>) {
        viewModelScope.launch {
            try {
                val answer = apiInterface.getLocationList(options)
                location = answer
                locationList += location.results
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    fun getLocationListWithName(option: Map<String, String>) {
        viewModelScope.launch {
            try {
                val answer = apiInterface.getLocationList(option)
                location = answer
                locationList = answer.results
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    fun getLocationUnit(id: String) {
        viewModelScope.launch {
            try {
                val answer = apiInterface.getLocationUnit(id)
                locationUnit = answer
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    fun getEpisodeList(options: Map<String, String>) {
        viewModelScope.launch {
            try {
                val answer = apiInterface.getEpisodeList(options)
                episode = answer
                episodeList += episode.results
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    fun getEpisodeListWithName(options: Map<String, String>) {
        viewModelScope.launch {
            try {
                val answer = apiInterface.getEpisodeList(options)
                episode = answer
                episodeList = answer.results
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    fun getEpisodeUnit(id: String) {
        viewModelScope.launch {
            try {
                val answer = apiInterface.getEpisodeUnit(id)
                episodeUnit = answer
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

}


