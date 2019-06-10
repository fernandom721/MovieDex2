package com.venrique.moviedexremastered.Viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.venrique.moviedexremastered.DB.MovieDatabase
import com.venrique.moviedexremastered.database.entidades.Movie
import com.venrique.moviedexremastered.movieRepository.MovieRepo
import com.venrique.moviedexremastered.retrofit.MovieService
import kotlinx.coroutines.launch

class MovieViewModel (private val app: Application) : AndroidViewModel(app){
    private val repository:MovieRepo

    init {
        val movieDAO=MovieDatabase.getInstance(app).movieDao()
        val movieService = MovieService.getGithubService()
        repository= MovieRepo(movieDAO, movieService)
    }

    private suspend fun insert(repo: Movie)=repository.insert(repo)


    fun retrieveRepo(user:String)=viewModelScope.launch {
        this@MovieViewModel.nuke()
        val response=repository.retrieveReposAsync(user).await()

        if(response.isSuccessful) with(response){
            this.body()?.forEach {
                this@MovieViewModel.insert(it)
            }
        }else with(response){
            when(response.code()){
                404->{
                    Toast.makeText(app, "F", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    fun getAll(): LiveData<List<Movie>> {
        return repository.getAll()
    }

    private suspend fun nuke()= repository.nuke()
}