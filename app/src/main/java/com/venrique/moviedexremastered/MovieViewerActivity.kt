package com.venrique.moviedexremastered

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.init
import com.venrique.moviedexremastered.database.entidades.Movie
import kotlinx.android.synthetic.main.movie_viewer.*

class MovieViewerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_viewer)


        //supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //supportActionBar?.setDisplayShowHomeEnabled(true)



       // val reciever: Movie = intent?.extras?.getParcelable("MOVIE") ?: Movie()
        //init(reciever)


    }

    fun init(movie: Movie){
        Glide.with(this)
            .load(movie.poster)
            .placeholder(R.drawable.ic_launcher_background)
            .into(image_main_content)
        movie_title_main_content.text=movie.title
        movie_rate_main_content.text=movie.rating
        released_main_content.text=movie.year
        genre_main_content.text=movie.genre
        runtime_main_content.text=movie.director
    }
}

