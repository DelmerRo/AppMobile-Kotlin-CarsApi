package ar.edu.ort.tp3.appmobile_kotlin_carsapi.service

import ar.edu.ort.tp3.appmobile_kotlin_carsapi.models.Car
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CarService {
    @GET("v1/cars")
    suspend fun getCars(
        @Header("X-Api-Key") apiKey: String,
        @Query("model") model: String
    ): Response<List<Car>>
}


