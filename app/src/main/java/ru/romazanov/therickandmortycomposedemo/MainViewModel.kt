package ru.romazanov.therickandmortycomposedemo

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.romazanov.therickandmortycomposedemo.data.models.characrer.Character
import ru.romazanov.therickandmortycomposedemo.data.models.characrer.Result
import ru.romazanov.therickandmortycomposedemo.data.models.episode.Episode
import ru.romazanov.therickandmortycomposedemo.data.models.location.Location
import ru.romazanov.therickandmortycomposedemo.data.retrofit.ApiInterface
import ru.romazanov.therickandmortycomposedemo.utils.PAGE

class MainViewModel: ViewModel() {



    lateinit var character: Character
    var episodeListState = mutableStateOf(Episode())
    var locationListState = mutableStateOf(Location())
    var lazyListState by mutableStateOf(LazyListState())
    private var errorMessage: String by mutableStateOf("")

    var characterList by mutableStateOf(listOf<Result>())

    init {
        getCharacterList(PAGE)
        getEpisodeList(PAGE)
        getLocationList(PAGE)
    }
    fun addCharacter(page: String) {
        viewModelScope.launch {
            val apiInterface = ApiInterface.getInstance()
            try {
                val answer = apiInterface.getCharacterList(page)
                character = answer
                characterList += character.results
            } catch (e: Exception) {
                errorMessage = e.message.toString()
                println(errorMessage)
            }
        }
    }

    private fun getCharacterList(page: String) {
        viewModelScope.launch {
            val apiInterface = ApiInterface.getInstance()
            try {
                val answer = apiInterface.getCharacterList(page)
                character = answer
                characterList = answer.results
            } catch (e: Exception) {
                errorMessage = e.message.toString()
                println(errorMessage)
            }
        }
    }

     private fun getEpisodeList(page: String) {
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
   private fun getLocationList(page: String) {
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


