package com.example.webserviceapplication.ui.list;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.webserviceapplication.R
import com.example.webserviceapplication.databinding.CardViewMovieItemBinding
import com.example.webserviceapplication.server.modelo.Character
import com.squareup.picasso.Picasso
import java.util.ArrayList
import kotlin.Unit

class CharactersListAdapter (
    private val charactersList: ArrayList<Character>,
    private val onItemClicked: (Character) -> Unit
) : RecyclerView.Adapter<CharactersListAdapter.CharactersViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_view_movie_item, parent, false)
        return CharactersViewHolder(itemView)
    }

    override fun getItemCount(): Int = charactersList.size

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        val character = charactersList[position]
        holder.bindMovie(character)
        holder.itemView.setOnClickListener { onItemClicked(character) }
    }

    fun appendItems(newList: ArrayList<Character>){
        charactersList.clear()
        charactersList.addAll(newList)
        notifyItemInserted(newList.size)
    }

    class CharactersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val binding = CardViewMovieItemBinding.bind(itemView)

        fun bindMovie(character: Character) {
            with(binding) {
                titleTextView.text = character.name
                voteAverageTextView.text = character.gender

                Picasso.get().load(character.image).into(pictureImageView)
            }
        }
    }


}
