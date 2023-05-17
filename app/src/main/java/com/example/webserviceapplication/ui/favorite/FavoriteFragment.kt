package com.example.webserviceapplication.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.webserviceapplication.R
import com.example.webserviceapplication.databinding.FragmentFavoriteBinding
import com.example.webserviceapplication.local.model.LocalMovie
import com.example.webserviceapplication.server.model.Movie
import com.example.webserviceapplication.ui.list.MoviesAdapter

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private lateinit var favoriteViewModel: FavoriteViewModel
    private val binding get() = _binding!!



    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?
    ): View {
        favoriteViewModel = ViewModelProvider(this)[FavoriteViewModel::class.java]
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)



        val favoriteMoviesList = ArrayList<LocalMovie>()
        val moviesFavoriteAdapter = MoviesFavoriteAdapter(
            favoriteMoviesList,
            onItemClicked = {},
            onItemLongClicked = {localMovie ->
                deleteFavoriteMovie(localMovie)
            })

        binding.moviesFavoriteRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@FavoriteFragment.requireContext())
        adapter = moviesFavoriteAdapter
        setHasFixedSize(false)
        }

        favoriteViewModel.loadFavoriteMovies()

        favoriteViewModel.favoriteMovies.observe(viewLifecycleOwner){favoriteMoviesList ->
            moviesFavoriteAdapter.appendItems(favoriteMoviesList)
        }

        return binding.root
    }

    private fun deleteFavoriteMovie(localMovie: LocalMovie) {
        val alertDialog: AlertDialog? = activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setMessage("Desea Eliminar la pelicula ${localMovie.title} de sus favoritos?")
                setPositiveButton(R.string.accept){ dialog, id ->
                    favoriteViewModel.deleteFavoriteMovie(localMovie)
                    favoriteViewModel.loadFavoriteMovies()
                }
                setNegativeButton(R.string.cancel){dialog, id ->

                }
            }
            builder.create()
        }
        alertDialog?.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}