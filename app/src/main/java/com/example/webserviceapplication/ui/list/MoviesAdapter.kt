package com.example.webserviceapplication.ui.list;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.webserviceapplication.R
import com.example.webserviceapplication.databinding.CardViewMovieItemBinding
import com.example.webserviceapplication.server.model.Movie
import com.squareup.picasso.Picasso
import java.util.ArrayList
import kotlin.Unit

class MoviesAdapter (
    private val moviesList: ArrayList<Movie>,
    private val onItemClicked: (Movie) -> Unit
) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_view_movie_item, parent, false)
        return MoviesViewHolder(itemView)
    }

    override fun getItemCount(): Int = moviesList.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = moviesList[position]
        holder.bindMovie(movie)
        holder.itemView.setOnClickListener { onItemClicked(movie) }
    }

    fun appendItems(newList: ArrayList<Movie>){
        moviesList.clear()
        moviesList.addAll(newList)
        notifyItemInserted(newList.size)
    }

    class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val binding = CardViewMovieItemBinding.bind(itemView)

        fun bindMovie(movie: Movie) {
            with(binding) {
                titleTextView.text = movie.title
                voteAverageTextView.text = "Vote average " + movie.voteAverage

                Picasso.get().load("https://image.tmdb.org/t/p/w500/"+movie.posterPath).into(pictureImageView)
            }
        }
    }


}
