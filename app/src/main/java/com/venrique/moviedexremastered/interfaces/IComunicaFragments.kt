package com.venrique.moviedexremastered.interfaces

import com.venrique.moviedexremastered.database.entidades.Movie

interface IComunicaFragments {
    fun enviarMovie(peli: Movie)
}