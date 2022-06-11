package ru.romazanov.therickandmortycomposedemo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.romazanov.therickandmortycomposedemo.data.models.characrer.Character
import ru.romazanov.therickandmortycomposedemo.data.models.episode.Episode
import ru.romazanov.therickandmortycomposedemo.data.models.location.Location
import ru.romazanov.therickandmortycomposedemo.data.retrofit.ApiInterface

class MainViewModel: ViewModel() {

    var characterListState = mutableStateOf(Character())
    var episodeListState = mutableStateOf(Episode())
    var locationListState = mutableStateOf(Location())

    private var errorMessage: String by mutableStateOf("")

    init {
        getCharacterList()
        getEpisodeList()
        getLocationList()
    }

    private fun getCharacterList() {
        viewModelScope.launch {
            val apiInterface = ApiInterface.getInstance()
            try {
                val answer = apiInterface.getCharacterList()
                characterListState.value = answer
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    private fun getEpisodeList() {
        viewModelScope.launch {
            val apiInterface = ApiInterface.getInstance()
            try {
                val answer = apiInterface.getEpisodeList()
                episodeListState.value = answer
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
    private fun getLocationList() {
        viewModelScope.launch {
            val apiInterface = ApiInterface.getInstance()
            try {
                val answer = apiInterface.getLocationList()
                locationListState.value = answer
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

}

