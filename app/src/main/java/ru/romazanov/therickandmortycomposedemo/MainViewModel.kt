package ru.romazanov.therickandmortycomposedemo

import androidx.compose.foundation.lazy.LazyListState
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
    var lazyListState by mutableStateOf(LazyListState())
    private var errorMessage: String by mutableStateOf("")

    var page = 1





    fun addCharacter(page: String) {
        viewModelScope.launch {
            val apiInterface = ApiInterface.getInstance()
            try {
                val answer = apiInterface.getCharacterList(page)
                characterListState.value.results += answer.results
            } catch (e: Exception) {
                errorMessage = e.message.toString()
                println(errorMessage)
            }
        }
    }


    fun getCharacterList(page: String) {
        viewModelScope.launch {
            val apiInterface = ApiInterface.getInstance()
            try {
                val answer = apiInterface.getCharacterList(page)
                characterListState.value = answer
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
                episodeListState.value = answer
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
                locationListState.value = answer
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

}

