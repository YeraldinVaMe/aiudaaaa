package com.example.crud_retrofit_jetpack_compose

import com.google.gson.annotations.SerializedName

data class UsuariosResponse(
    @SerializedName("data")
    val data: ArrayList<Usuario>,
    @SerializedName("message")
    val mensaje: String,
    @SerializedName("status")
    val codigo: Int

)
