package ar.edu.ort.tp3.appmobile_kotlin_carsapi.service

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CarServiceApiBuilder {
    private const val BASE_URL = "https://api.api-ninjas.com/"

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .build()

    fun getCarService(): CarService {
        return retrofit.create(CarService::class.java)
    }
}