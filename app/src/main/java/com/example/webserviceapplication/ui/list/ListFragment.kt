package com.example.webserviceapplication.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.webserviceapplication.databinding.FragmentListBinding
import com.example.webserviceapplication.server.modelo.Character

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val listViewModel = ViewModelProvider(this)[ListViewModel::class.java]

        _binding = FragmentListBinding.inflate(inflater, container, false)

        val charactersList = ArrayList<Character>()
        val charactersListAdapter = CharactersListAdapter(charactersList, onItemClicked = { character -> onItemClicked(character)})

        binding.moviesRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@ListFragment.requireContext())
            adapter = charactersListAdapter
            setHasFixedSize(false)
        }

        listViewModel.loadMovies()

        listViewModel.charactersLoaded.observe(viewLifecycleOwner){listCharacters ->
            charactersListAdapter.appendItems(listCharacters)
        }

        return binding.root
    }

    private fun onItemClicked(character: Character){
    //    findNavController().navigate(ListFragmentDirections.actionNavigationListToNavigationDetail(movie = movie))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}