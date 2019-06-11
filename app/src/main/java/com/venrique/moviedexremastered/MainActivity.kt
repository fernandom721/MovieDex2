package com.venrique.moviedexremastered

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.venrique.moviedexremastered.database.entidades.Movie
import com.venrique.moviedexremastered.fragments.movieListFragment

class MainActivity : AppCompatActivity(),movieListFragment.OnFragmentInteractionListener  {
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentoLista = movieListFragment()

        supportFragmentManager.beginTransaction().replace(R.id.containerFrag,fragmentoLista).commit()

    }



    private fun elintent(movie: Movie){
        val movieBundle = Bundle()
        movieBundle.putParcelable("MOVIE", movie)
        startActivity(Intent(this, MovieViewerActivity::class.java).putExtras(movieBundle))
    }

    private fun Bundle.putParcelable(s: String, movie: Movie) {

    }
}
