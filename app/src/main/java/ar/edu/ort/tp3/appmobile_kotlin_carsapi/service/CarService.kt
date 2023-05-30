package ar.edu.ort.tp3.appmobile_kotlin_carsapi.service

import android.widget.EditText
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.models.Car
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CarService {
    @GET("v1/cars")
    suspend fun getCarsForMake(@Header("X-Api-Key") apiKey: String, @Query("make") model: String): Response<List<Car>>

    @GET("v1/cars")
    suspend fun getCarsForYear(@Header("X-Api-Key") apiKey: String, @Query("year") model: String): Response<List<Car>>

    @GET("v1/cars")
    suspend fun getCarsForTransmission(@Header("X-Api-Key") apiKey: String, @Query("model") model: String): Response<List<Car>>

    @GET("v1/cars")
    suspend fun getCarsForFuelType(@Header("X-Api-Key") apiKey: String, @Query("fuel_type") model: String): Response<List<Car>>
}

