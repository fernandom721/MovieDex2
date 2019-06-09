package com.venrique.moviedexremastered.retrofit

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.venrique.moviedexremastered.database.entidades.Movie
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

const val BASE_URL = "http://www.omdbapi.com/"

interface MovieService {

    @GET("/?apikey=8b0b11f6&t={peli}")
    fun getMovies(@Path("peli") peli: String): Deferred<Response<List<Movie>>>

    companion object{
        var INSTANCE: MovieService? = null

        fun getGithubService(): MovieService{
            if (INSTANCE != null){
                return INSTANCE!!
            }else{
                INSTANCE = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .build()
                    .create(MovieService::class.java)
                return INSTANCE!!
            }
        }
    }
}