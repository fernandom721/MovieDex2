package com.venrique.moviedexremastered.Viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.venrique.moviedexremastered.DB.MovieDatabase
import com.venrique.moviedexremastered.database.entidades.Movie
import com.venrique.moviedexremastered.movieRepository.MovieRepo

class MovieViewModel (private val app: Application) : AndroidViewModel(app){
    private val repository:MovieRepo

    init {
        val movieDAO=MovieDatabase.getInstance(app).movieDao()
        repository= MovieRepo(movieDAO)
    }

    private suspend fun insert(repo: Movie)=repository.insert(repo)

    fun getAll(): LiveData<List<Movie>> {
        return repository.getAll()
    }

    private suspend fun nuke()= repository.nuke()
}