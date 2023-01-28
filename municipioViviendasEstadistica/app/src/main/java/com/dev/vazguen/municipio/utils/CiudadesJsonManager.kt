package com.dev.vazguen.municipio.utils

import android.content.Context
import android.content.res.Resources
import android.util.Log
import com.dev.vazguen.municipio.R
import com.dev.vazguen.municipio.model.MunicipioDataClass
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CiudadesJsonManager(resources:Resources): java.lang.Exception() {
    val jsonCiudadPath="alquiler/municipios.json"
    val jsonFile = resources.openRawResource(R.raw.municipios)

    fun  loadJson():String{
        ///region Info: TODO Leer fichero desde la carpeta
        // ASSENTS FOLDER
        //RAW: Tiene solo ficheros base,  folder resources.openRawResource(R.raw.filename)

        // Assents : Puede crear carpetas, listar fichero en el tiempo de ejecucion
        // assets.open(“filename”)
        // listar en el tiempo de ejecucion : assets.list(FOLDER_NAME)?.forEach {
        //
        //       println(it)
        //
        //    }
        //resources.openRawResource(R.raw.test)
        //val jsonFile = resources.openRawResource(R.raw.municipios)
        ///endregion

        val jsonTxt= jsonFile.bufferedReader().use { it.readText() }

        return  jsonTxt
    }
    fun loagData(inFIle:String, context: Context):String{
        var jsonString=""
        try {

            jsonString = context.assets.open(inFIle).bufferedReader().use {
                it.readText()
            }.toString()

        }
        catch (_:java.lang.Exception){

        }
        finally {
            jsonFile.close()
        }

        return jsonString
    }

    fun serializeToObject(): List<MunicipioDataClass> {
        val listPersonType = object : TypeToken<List<MunicipioDataClass>>() {}.type
        val gson = Gson()

        try {
              return  gson.fromJson(loadJson(), listPersonType)
            //ciudades.forEachIndexed { idx, ciudades -> Log.i("data", "> Item $idx:\n$ciudades") }
        }
        catch (e:Exception){
            Log.e("Serialize_Json_Excepcion",e.toString())
        }

        return ArrayList<MunicipioDataClass>()
    }

    object JsonManager {
        fun parceJson(){
            val gson = Gson()
            val listPersonType = object : TypeToken<List<MunicipioDataClass>>() {}.type

            var persons: List<MunicipioDataClass> = gson.fromJson( "", listPersonType)
        }


    }

}