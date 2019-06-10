package com.venrique.moviedexremastered

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
}
