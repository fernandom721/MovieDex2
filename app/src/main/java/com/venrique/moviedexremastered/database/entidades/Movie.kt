package com.venrique.moviedexremastered.database.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "peliculas")
data class Movie(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @field:Json(name = "Title")
    val title: String,
    @field:Json(name = "Year")
    val year: String,
    @field:Json(name = "Genre")
    val genre: String,
    @field:Json(name = "Director")
    val director: String,
    @field:Json(name = "Poster")
    val poster: String,
    @field:Json(name = "Rated")
    val rating: String
)