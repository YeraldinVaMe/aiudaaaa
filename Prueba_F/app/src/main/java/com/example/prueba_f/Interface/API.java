package com.example.prueba_f.Interface;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    String BASE_URL = "http://127.0.0.1:5000/";

    @GET("/predio")
    Call<String> getPredio();
}
