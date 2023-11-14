package com.example.crud_retrofit_jetpack_compose

import com.google.gson.annotations.SerializedName

data class Usuario(
    @SerializedName("altitud")
    var altitud: Double? ,
    @SerializedName("departamento")
    var departamento: String,
    @SerializedName("distrito")
    var distrito: String?,
    @SerializedName("idubigeo")
    var idubigeo: String,
    @SerializedName("latitud")
    var latitud: Double?,
    @SerializedName("longitud")
    var longitud: Double?,
    @SerializedName("provincia")
    var provincia: String?,
    @SerializedName("superficie")
    var superficie: Double?
)
