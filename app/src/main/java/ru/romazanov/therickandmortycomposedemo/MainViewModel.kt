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
import ru.romazanov.therickandmortycomposedemo.utils.PAGE

class MainViewModel : ViewModel() {



    var favorite by mutableStateOf(listOf<Favorite>())

    var character by mutableStateOf(Character())
    var episode by mutableStateOf(Episode())
    var location by mutableStateOf(Location())

    private var errorMessage: String by mutableStateOf("")

    var characterList by mutableStateOf(listOf<Result>())
    var episodeList by mutableStateOf(listOf<ru.romazanov.therickandmortycomposedemo.data.models.episode.Result>())
    var locationList by mutableStateOf(listOf<ru.romazanov.therickandmortycomposedemo.data.models.location.Result>())

    init {
        getCharacterList(PAGE)
        getEpisodeList(PAGE)
        getLocationList(PAGE)
    }



     fun getCharacterList(page: String) {
        viewModelScope.launch {
            val apiInterface = ApiInterface.getInstance()
            try {
                val answer = apiInterface.getCharacterList(page)
                character = answer
                characterList += answer.results
            } catch (e: Exception) {
                errorMessage = e.message.toString()
                println(errorMessage)
            }
        }
    }

  fun getEpisodeList(page: String) {
        viewModelScope.launch {
            val apiInterface = ApiInterface.getInstance()
            try {
                val answer = apiInterface.getEpisodeList(page)
                episode = answer
                episodeList += episode.results
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

     fun getLocationList(page: String) {
        viewModelScope.launch {
            val apiInterface = ApiInterface.getInstance()
            try {
                val answer = apiInterface.getLocationList(page)
                location = answer
                locationList += location.results
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

}


