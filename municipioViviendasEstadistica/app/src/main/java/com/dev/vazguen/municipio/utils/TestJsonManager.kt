package com.dev.vazguen.municipio.utils

import android.app.Person
import android.content.Context
import android.content.res.Resources
import com.dev.vazguen.municipio.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException


class TestJsonManager(var json: String) {
    fun serializeJson():List<Person>{
    val gson = Gson()
    val listPersonType = object : TypeToken<List<Person>>() {}.type
    return gson.fromJson(json, listPersonType)

    }
}


/*
//Oncreate file
fun test(){
    var jsonString: String=""
    try {
        jsonString = this.assets.open("alquiler/test.json").bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()

    }
    val listPersonType = object : TypeToken<List<com.dev.vazguen.municipio.utils.Person>>() {}.type
    val gson = Gson()
    var persons: List<com.dev.vazguen.municipio.utils.Person> = gson.fromJson(jsonString, listPersonType)
}
*/