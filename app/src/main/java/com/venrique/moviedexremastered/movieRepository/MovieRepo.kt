package com.venrique.moviedexremastered.movieRepository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.venrique.moviedexremastered.DAO.movieDAO
import com.venrique.moviedexremastered.database.entidades.Movie

class MovieRepo (private val movieDao:movieDAO){
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


}