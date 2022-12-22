package com.dev.vazguen.recyclerview.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dev.vazguen.recyclerview.R
import com.dev.vazguen.recyclerview.SuperHeroes

class SuperHeroAdapter(private val superherolist:List<SuperHeroes>):
    RecyclerView.Adapter<SuperHeroViewHolder>()
{
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
      val layoutInflater = LayoutInflater.from(parent.context)
        return  SuperHeroViewHolder(layoutInflater.inflate(R.layout.item_superhero,parent,false))
     }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        val item = superherolist[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = superherolist.size

}