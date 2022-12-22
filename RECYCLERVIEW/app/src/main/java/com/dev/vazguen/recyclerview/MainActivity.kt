package com.dev.vazguen.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dev.vazguen.recyclerview.adapter.SuperHeroAdapter

/*
* @autor: Vazgen Martirosyan
* */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecylerView()
    }
     fun initRecylerView(){
         val recyclerView = findViewById<RecyclerView>(R.id.recylerSuperHero)
         recyclerView.layoutManager = LinearLayoutManager(this)
         recyclerView.adapter = SuperHeroAdapter(SuperHeroProvider.superHeroList)
     }
}