package com.dev.vazguen.municipio.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dev.vazguen.municipio.R
import com.dev.vazguen.municipio.model.MunicipioDataClass


class DatosAdapter(private val ciudadeslist:List<MunicipioDataClass>): RecyclerView.Adapter<DatosViewHolder>()
{
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DatosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return  DatosViewHolder(layoutInflater.inflate(R.layout.item_datos_ciudad,parent,false))
    }

    override fun onBindViewHolder(holder: DatosViewHolder, position: Int) {
        val item = ciudadeslist[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = ciudadeslist.size

}