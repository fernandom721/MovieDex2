package com.venrique.moviedexremastered.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.venrique.moviedexremastered.database.entidades.Movie

@Dao
interface movieDAO{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie: movieDAO)

    @Query("SELECT*FROM peliculas")
    fun getAllMovies():LiveData<List<Movie>>

    @Query("DELETE FROM peliculas")
    suspend fun nukeTable()



}