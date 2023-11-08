package com.example.prueba_f

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.prueba_f.Interface.API
import org.json.JSONArray
import org.json.JSONException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var spPredio:Spinner
    private lateinit var getPredioCorreo:ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spPredio = findViewById(R.id.spPredio)
        getPredio()
    }

    private fun getPredio() {
        Toast.makeText(applicationContext, "entra predio", Toast.LENGTH_LONG).show();
        val retrofit = Retrofit.Builder()
            .baseUrl(API.BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()

        val ap = retrofit.create(API::class.java)
        val call = ap.getPredio()
        Toast.makeText(applicationContext, call.request().url().toString(), Toast.LENGTH_LONG).show();
        call.enqueue(object : Callback<String>{
            override fun onResponse(call: Call<String>, response: Response<String>) {
                Toast.makeText(applicationContext, "RESPONSE", Toast.LENGTH_LONG).show();
                Log.i("Response",response.body().toString())
                if(response.isSuccessful){
                    Toast.makeText(applicationContext, "conectat", Toast.LENGTH_LONG).show();

                    if (response.body() != null){
                        Log.i("Success",response.body().toString())
                        try {
                            val getResponse = response.body().toString()
                            val getstateData = ArrayList<Predio>()
                            val jsonArray = JSONArray(getResponse)
                            getstateData.add(Predio(-1,"-- Seleccione --"))
                            for (i in 0 until jsonArray.length()){
                                val predios = Predio()
                                val jsonObject = jsonArray.getJSONObject(i)
                                predios.setID(jsonObject.getInt("id_predio"))
                                predios.setDescripcion(jsonObject.getString("descripcion"))
                                getstateData.add(predios)
                            }
                            val getstateName = ArrayList<String> ()
                            for (i in 0 until getstateData.size){
                                getstateName.add(getstateData[i].descripcion)
                            }
                            val spin = ArrayAdapter(
                                this@MainActivity,
                                android.R.layout.simple_spinner_item,
                                getstateName
                            )
                            spin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                            spPredio.adapter = spin
                            spPredio.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                                override fun onItemSelected(
                                    p0: AdapterView<*>?,
                                    p1: View?,
                                    p2: Int,
                                    p3: Long
                                ) {
                                    //
                                }

                                override fun onNothingSelected(p0: AdapterView<*>?) {
                                    //
                                }
                            }
                        } catch (ex: JSONException){
                            ex.printStackTrace()
                        }
                    }
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Toast.makeText(applicationContext, "FAIL"+t.message.toString(), Toast.LENGTH_LONG).show();
            }

        })

    }
}