package com.example.prueba_f.api

import com.example.prueba_f.entidades.Predio
import retrofit2.http.*
import retrofit2.*
interface ConsumirAPI_GestionClientes {
    @GET("predio")
    fun getTraer(): Call<Predio>

}