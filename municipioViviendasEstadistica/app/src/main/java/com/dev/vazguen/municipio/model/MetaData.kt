package com.dev.vazguen.municipio.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.descriptors.StructureKind
import java.util.Objects
import kotlin.annotation.AnnotationTarget.CLASS

annotation class Entity(val Variable: String)
@Retention(AnnotationRetention.RUNTIME)
@Target(CLASS)
annotation class MyAnnotation
//@Entity(Variable = "Variable")
data class Variable(
    @SerializedName("Nombre") @Expose
    val nombre:String?,
    @SerializedName("Codigo") @Expose
    val codigo:String?)



data class MetaData(
    @SerializedName(value = "Variable")@Expose
    val variable: Variable?,
    @SerializedName("Nombre") @Expose
    val nombre:String?,
    @SerializedName("Codigo") @Expose
    val codigo:String?)