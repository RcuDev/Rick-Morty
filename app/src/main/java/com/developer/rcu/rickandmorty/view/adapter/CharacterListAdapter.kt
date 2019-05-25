package com.developer.rcu.rickandmorty.view.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.developer.rcu.rickandmorty.R
import com.developer.rcu.rickandmorty.model.network.Character
import kotlinx.android.synthetic.main.character_list_item.view.*
import javax.inject.Inject

/**
 * Created by Raul Corvo on 27/11/2018
 */
class CharacterListAdapter @Inject constructor() :
    androidx.recyclerview.widget.RecyclerView.Adapter<CharacterListAdapter.CharacterListViewHolder>() {

    internal var collection: MutableList<Character> = arrayListOf()
    internal var clickListener: (Character, ImageView) -> Unit = { character, imageView ->}
    internal lateinit var context: Context

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CharacterListViewHolder =
        CharacterListViewHolder(LayoutInflater.from(context).inflate(R.layout.character_list_item, viewGroup, false))

    override fun getItemCount() = collection.size

    override fun onBindViewHolder(viewHolder: CharacterListViewHolder, position: Int) =
        viewHolder.bind(collection[position], clickListener)

    class CharacterListViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        fun bind(character: Character, clickListener: (Character, ImageView) -> Unit) {
            Glide.with(itemView)
                .load(character.image)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(itemView.characterImage)
            itemView.characterName.text = character.name
            itemView.setOnClickListener { clickListener(character, itemView.characterImage) }
        }
    }
}