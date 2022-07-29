package ru.romazanov.therickandmortycomposedemo.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap
import ru.romazanov.therickandmortycomposedemo.data.models.characrer.Character
import ru.romazanov.therickandmortycomposedemo.data.models.characrer.Result
import ru.romazanov.therickandmortycomposedemo.data.models.episode.Episode
import ru.romazanov.therickandmortycomposedemo.data.models.location.Location
import ru.romazanov.therickandmortycomposedemo.utils.BASE_URL

interface ApiInterface {

    @GET("character")
    suspend fun getCharacterList(
        @QueryMap() options: Map<String, String>
    ): Character
    @GET("character/{id}")
    suspend fun getCharacterUnit(
        @Path("id") id: String
    ): Result


    @GET("episode")
    suspend fun getEpisodeList(
        @QueryMap() options: Map<String, String>
    ): Episode
    @GET("episode/{id}")
    suspend fun getEpisodeUnit(
        @Path("id") id: String
    ): ru.romazanov.therickandmortycomposedemo.data.models.episode.Result


    @GET("location")
    suspend fun getLocationList(
        @QueryMap() options: Map<String, String>
    ): Location
    @GET("location/{id}")
    suspend fun getLocationUnit(
        @Path("id") id: String
    ): ru.romazanov.therickandmortycomposedemo.data.models.location.Result

    companion object {
        var api: ApiInterface? = null
        fun getInstance(): ApiInterface {
            if (api == null) {
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