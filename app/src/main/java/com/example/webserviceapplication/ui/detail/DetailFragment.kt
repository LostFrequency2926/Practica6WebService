package com.example.webserviceapplication.ui.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.webserviceapplication.R
import com.example.webserviceapplication.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private lateinit var detailViewModel: DetailViewModel
    private lateinit var detailBinding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()
    private var isMovieFavorite = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {

        detailViewModel = ViewModelProvider(this)[DetailViewModel::class.java]
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)

        detailViewModel.isMovieFavorite.observe(viewLifecycleOwner){isMovieFavorite ->
            this.isMovieFavorite = isMovieFavorite
            if(isMovieFavorite){
                detailBinding.addFavoriteIcon.setImageDrawable(resources.getDrawable(R.drawable.favoritoicon))
            }else{
                detailBinding.addFavoriteIcon.setImageDrawable(resources.getDrawable(R.drawable.favoritoicon2))
            }
        }

        val movie = args.movie

        detailViewModel.searchMovie(movie.id)

        with(detailBinding){
            titleTextView.text = movie.title
            releaseDateTextView.text = "Release date: " + movie.releaseDate
            averageTextView.text = "Vote average: " + movie.voteAverage.toString()
            summaryTextView.text= movie.overview
            Picasso.get().load("https://image.tmdb.org/t/p/w500/"+movie.posterPath).into(posterImageView)

            addFavoriteIcon.setOnClickListener{
                if(isMovieFavorite)
                    Toast.makeText(context, "${movie.title} ya esta en tus favoritos", Toast.LENGTH_LONG).show()
                else{
                    isMovieFavorite = true
                    addFavoriteIcon.setImageDrawable(resources.getDrawable(R.drawable.favoritoicon))
                    detailViewModel.saveMovie(movie)
                }
            }
        }

        return detailBinding.root
    }
}