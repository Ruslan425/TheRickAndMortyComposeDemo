package ru.romazanov.therickandmortycomposedemo.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import ru.romazanov.therickandmortycomposedemo.data.models.characrer.Character
import ru.romazanov.therickandmortycomposedemo.data.models.episode.Episode
import ru.romazanov.therickandmortycomposedemo.data.models.location.Location
import ru.romazanov.therickandmortycomposedemo.utils.BASE_URL

interface ApiInterface {

    @GET("character?page=1")
    suspend fun getCharacterList(): Character

    @GET("episode?page=1")
    suspend fun getEpisodeList(): Episode

    @GET("location?page=1")
    suspend fun getLocationList(): Location

    companion object {
        var api: ApiInterface? = null
        fun getInstance(): ApiInterface {
            if(api == null) {
                api = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiInterface::class.java)
            }
            return api!!
        }
    }



}