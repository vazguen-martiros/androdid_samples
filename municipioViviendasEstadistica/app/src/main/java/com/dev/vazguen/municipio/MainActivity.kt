package com.dev.vazguen.municipio

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.dev.vazguen.municipio.utils.CiudadesJsonManager
import com.dev.vazguen.municipio.utils.Person
import com.dev.vazguen.municipio.utils.TestJsonManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

/*
* @autor: Vazguen
* @data: 16/01/2023
**/
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recylerView: RecyclerView = findViewById<RecyclerView>(R.id.recylerview)
        recylerView.layoutManager = LinearLayoutManager(this)

        //parseObject(
       // val jsonManager:CiudadesJsonManager = CiudadesJsonManager(this.resources)
        //val ciudades = jsonManager.serializeToObject()

    }
}