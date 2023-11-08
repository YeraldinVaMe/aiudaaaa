package com.example.prueba_f.conection

import com.example.prueba_f.api.PredioApi
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

object ImplementacionAPI_GestionClientes {

    private val retrofit= Retrofit.Builder()
        .baseUrl("http://127.0.0.1:5000/")  //esta url cambiar "172.22.224.1" por tu ipv4
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val consumirAPI4= retrofit.create(PredioApi::class.java)
}