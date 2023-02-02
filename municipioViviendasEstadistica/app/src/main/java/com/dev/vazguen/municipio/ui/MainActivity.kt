package com.dev.vazguen.municipio.ui

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dev.vazguen.municipio.R
import com.dev.vazguen.municipio.model.Municipio
import com.dev.vazguen.municipio.model.MunicipioDataClass
import com.dev.vazguen.municipio.ui.adapter.DatosAdapter
import com.dev.vazguen.municipio.utils.CiudadesJsonManager
import java.util.Objects

/*
* @autor: Vazguen
* @data: 16/01/2023
**/
class MainActivity : AppCompatActivity() {
    var spinnerCiudad:Spinner? = null
    var recylerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerCiudad = findViewById<Spinner>(R.id.spinnerFiltrarCiudad)

        recylerView = findViewById<RecyclerView>(R.id.recylerview)
        recylerView?.layoutManager = LinearLayoutManager(this)
        recylerView?.adapter = DatosAdapter(ciudades)
        
        val jsonManager: CiudadesJsonManager = CiudadesJsonManager(this.resources)
        val ciudades = jsonManager.serializeToObject()


        spinnerCiudad?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                // filtrar ciudades segun los valores selecionado y mostrar en recylerview
                // 17095-Lloret de Mar: Girona , filtrar por profincia
                val result = selectedItem.substring(selectedItem.indexOf(":")).replace(":".toRegex(),"")
                filtrarDatos(result, ciudades  )

            }
            override fun onNothingSelected(adapter: AdapterView<*>?) {


            }

        }
        setValuesSpinner(ciudades)
    }

    private fun setValuesSpinner(ciudades:List<MunicipioDataClass>) {
        //parse json to object



        ///region Filtrar segun ciudad
        val data = arrayListOf<String>()
        ciudades.sortedByDescending { it.nombre }
        for (item in ciudades) {
            val output = item.nombre.toString().replaceBefore(":","")
            data.add("> "+output)
        }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data.distinct())
        spinnerCiudad?.adapter = adapter
        ///endregion


    }
    private  fun convertToMunicipioObject( originalObjects: MunicipioDataClass): Municipio? {
        val converted:Municipio? = null
        //17095-Lloret de Mar: Girona
        converted?.nombre = originalObjects.nombre.toString().replaceBefore("-","")
        converted?.codigoPostal=  originalObjects.nombre.toString().replaceAfter("-","")
        converted?.provincia=originalObjects.nombre.toString().replaceAfter(":","")

        return converted
    }
    private  fun filtrarDatos(query:String, ciudadesList:List<MunicipioDataClass>){
        //filtrar
        val filteredData = ciudadesList!!.filter {it.nombre!!.contains(query)}
        val adapter = DatosAdapter(filteredData)
        recylerView!!.adapter = adapter
    }


}

