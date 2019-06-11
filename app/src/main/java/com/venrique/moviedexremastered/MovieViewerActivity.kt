package com.venrique.moviedexremastered

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.venrique.moviedexremastered.database.entidades.Movie

class MovieViewerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_viewer)


        //val reciever: Movie = intent?.extras?.getParcelable("MOVIE") ?: Movie()
       // init(reciever)


    }

}