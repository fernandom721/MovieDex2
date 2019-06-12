package com.venrique.moviedexremastered

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.venrique.moviedexremastered.database.entidades.Movie
import com.venrique.moviedexremastered.fragments.movieDetailFragment
import com.venrique.moviedexremastered.fragments.movieListFragment
import com.venrique.moviedexremastered.interfaces.IComunicaFragments

class MainActivity : AppCompatActivity(),movieListFragment.OnFragmentInteractionListener, movieDetailFragment.OnFragmentInteractionListener, IComunicaFragments  {
    override fun enviarMovie(peli: Movie) {
        if(findViewById<LinearLayout>(R.id.containerFrag)==null){
            TODO("not implemented")
        }else{
            fragmentoDetalle = movieDetailFragment()

            var bundleEnvio = Bundle()
            bundleEnvio.putSerializable("objeto",peli)

            fragmentoDetalle.arguments = bundleEnvio

            supportFragmentManager.beginTransaction().replace(R.id.containerFrag,fragmentoDetalle).addToBackStack(null).commit()
        }
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    lateinit var fragmentoLista: movieListFragment
    lateinit var fragmentoDetalle: movieDetailFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentoLista = movieListFragment()

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
