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
    @ColumnInfo(name = "Title")
    val titulo: String
)