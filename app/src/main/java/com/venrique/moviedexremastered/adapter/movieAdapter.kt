package com.venrique.moviedexremastered.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.venrique.moviedexremastered.R
import com.venrique.moviedexremastered.database.entidades.Movie
import kotlinx.android.synthetic.main.movie_card.view.*

class movieAdapter(var pelis:List<Movie>): RecyclerView.Adapter<movieAdapter.VieHolder>(), View.OnClickListener {

    private var listener: View.OnClickListener? = null

    override fun onClick(v: View?) {
        if(listener!=null){
            listener?.onClick(v)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VieHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_card,parent,false)
        view.setOnClickListener(this)
        return VieHolder(view)
    }

    fun setOnClickListener(listener: View.OnClickListener){
        this.listener = listener
    }

    override fun getItemCount(): Int {
        return pelis.size
    }

    override fun onBindViewHolder(holder: VieHolder, position: Int) {
        holder.bind(pelis[position])
    }

    fun updateList(newMovies: List<Movie>){
        this.pelis = newMovies
        notifyDataSetChanged()
    }


    class VieHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(peli: Movie) = with(itemView){
            this.tv_name.text = peli.title
        }

    }
}