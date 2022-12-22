package com.dev.vazguen.recyclerview.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.dev.vazguen.recyclerview.R
import com.dev.vazguen.recyclerview.SuperHeroes

class SuperHeroViewHolder(val view: View):RecyclerView.ViewHolder(view) {
    val superHero = view.findViewById<TextView>(R.id.ivSuperHero)
    val superName = view.findViewById<TextView>(R.id.tvRealName)
    val publisher = view.findViewById<TextView>(R.id.tvPublisher)
    val photo = view.findViewById<ImageView>(R.id.ivSuperHero)

    fun render(superHeroModel: SuperHeroes){
        superHero.text = superHeroModel.superHeroe
        superName.text = superHeroModel.nombreReal
        publisher.text = superHeroModel.pulisher
        Glide.with(photo.context).load(superHeroModel.photo).into(photo)
    }
}