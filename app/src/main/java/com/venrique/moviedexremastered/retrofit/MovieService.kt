package com.venrique.moviedexremastered.retrofit

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.venrique.moviedexremastered.database.entidades.Movie
import com.venrique.moviedexremastered.database.entidades.MovieResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val BASE_URL = "http://www.omdbapi.com/"

interface MovieService {

    @GET("/?apikey=8b0b11f6")
    fun getMovies(@Query("s") peli: String): Deferred<Response<MovieResponse>>

    @GET("/?apikey=8b0b11f6")
    fun getMovieInfo(@Query("t") peli: String): Deferred<Response<Movie>>

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