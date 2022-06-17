package ru.romazanov.therickandmortycomposedemo.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.romazanov.therickandmortycomposedemo.data.models.characrer.Character
import ru.romazanov.therickandmortycomposedemo.data.models.episode.Episode
import ru.romazanov.therickandmortycomposedemo.data.models.location.Location
import ru.romazanov.therickandmortycomposedemo.utils.BASE_URL

interface ApiInterface {

    @GET("character")
    suspend fun getCharacterList(
        @Query("page") page: String
    ): Character

    @GET("character")
    suspend fun getCharacterListWithName(
        @Query("name") name: String
    ): Character

    @GET("episode")
    suspend fun getEpisodeList(
        @Query("page") page: String
    ): Episode

    @GET("location")
    suspend fun getLocationList(
        @Query("page") page: String
    ): Location


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