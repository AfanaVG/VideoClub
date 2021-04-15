package com.example.videoclub.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.videoclub.model.Movie
import com.example.videoclub.utils.loadImage
import kotlinx.android.synthetic.main.item_movie.view.*

class MoviesViewHolder (view:View):RecyclerView.ViewHolder(view){
    fun bind(movie: Movie){
        itemView.movieTitle.text = movie.name
        movie.cover?.let {movie ->
            itemView.movieCover.loadImage(movie)
        }
    }
}