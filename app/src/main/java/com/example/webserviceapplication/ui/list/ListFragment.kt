package com.example.webserviceapplication.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.webserviceapplication.databinding.FragmentListBinding
import com.example.webserviceapplication.server.model.Movie

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val listViewModel = ViewModelProvider(this)[ListViewModel::class.java]

        _binding = FragmentListBinding.inflate(inflater, container, false)

        val moviesList = ArrayList<Movie>()
        val moviesAdapter = MoviesAdapter(moviesList, onItemClicked = {movie -> onItemClicked(movie)})

        binding.moviesRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@ListFragment.requireContext())
            adapter = moviesAdapter
            setHasFixedSize(false)
        }

        listViewModel.loadMovies()

        listViewModel.moviesLoaded.observe(viewLifecycleOwner){listMovies ->
            moviesAdapter.appendItems(listMovies)
        }

        return binding.root
    }

    private fun onItemClicked(movie: Movie){
        findNavController().navigate(ListFragmentDirections.actionNavigationListToNavigationDetail(movie = movie))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}