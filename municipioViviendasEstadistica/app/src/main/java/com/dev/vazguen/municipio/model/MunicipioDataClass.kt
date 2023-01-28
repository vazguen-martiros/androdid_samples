package com.dev.vazguen.municipio.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class MunicipioDataClass (
    @SerializedName("Nombre") @Expose
    var nombre: String? = null,
    @SerializedName("MetaData") @Expose
    var metadata:List<MetaData> ? = null,//MetaData
    @SerializedName("Data") @Expose // "Data":[{"Valor":33.04}
    var data: ArrayList<Valor>? = null,
    )