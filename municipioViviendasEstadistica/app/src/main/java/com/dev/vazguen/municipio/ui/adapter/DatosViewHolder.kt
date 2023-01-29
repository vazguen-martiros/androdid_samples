package com.dev.vazguen.municipio.ui.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dev.vazguen.municipio.R
import com.dev.vazguen.municipio.model.MunicipioDataClass



class DatosViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val ciudadDatos = view.findViewById<TextView>(R.id.tvNombreCiudad)

    fun render(ciudadModel: MunicipioDataClass){
        ciudadDatos.text = ciudadModel.nombre
    }
}