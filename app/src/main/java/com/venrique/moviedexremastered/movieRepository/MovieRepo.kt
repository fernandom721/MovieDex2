package com.venrique.moviedexremastered.movieRepository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.venrique.moviedexremastered.database.DAO.movieDAO
import com.venrique.moviedexremastered.database.entidades.Movie
import com.venrique.moviedexremastered.database.entidades.MovieResponse
import com.venrique.moviedexremastered.retrofit.MovieService
import kotlinx.coroutines.Deferred
import retrofit2.Response

class MovieRepo (private val movieDao:movieDAO, private val MovieService: MovieService){
    @WorkerThread
    suspend fun insert(repo: Movie){
        movieDao.insert(repo)
    }
    fun getAll(): LiveData<List<Movie>> {
        return movieDao.getAllMovies()
    }
    @WorkerThread
    suspend fun nuke(){
        return movieDao.nukeTable()
    }

    fun retrieveReposAsync(user:String): Deferred<Response<MovieResponse>> {
        return MovieService.getMovies(user)
    }

    fun retrieveMovie(peli: String): Deferred<Response<Movie>>{
        return MovieService.getMovieInfo(peli)
    }

}