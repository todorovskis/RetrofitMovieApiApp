package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.domain.movie.model.Movie

class MovieAdapter(private var movie: Movie? = null) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var imageView: ImageView = view.findViewById(R.id.imageView)
        private var title: TextView = view.findViewById(R.id.title)
        private var yearReleased: TextView = view.findViewById(R.id.year_released)

        fun bind(movie: Movie) {
            Glide.with(imageView)
                .load(movie.poster).centerCrop().placeholder(R.drawable.ic_launcher_foreground)
                .into(imageView)
            title.text = movie.title
            yearReleased.text = movie.year.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 1;
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        if (movie != null) {
            holder.bind(movie!!)
        }
    }

    fun updateMovie(movie: Movie) {
        this.movie = movie
        notifyDataSetChanged()
    }
}