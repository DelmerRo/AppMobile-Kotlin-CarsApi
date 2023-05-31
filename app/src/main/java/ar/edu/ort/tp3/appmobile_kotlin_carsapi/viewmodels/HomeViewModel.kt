package ar.edu.ort.tp3.appmobile_kotlin_carsapi.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.models.Car
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.service.CarServiceApiBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel: ViewModel() {
    val carList: MutableLiveData<List<Car>> = MutableLiveData()
    private var apiKey = "VyFRiZ7J1W4Vbzuk89yLRA==qWOIgbFZ7H6YB8lI"
    fun searchCars(searchText: String) {
       if(searchText != "0"){
        viewModelScope.launch {
            val service = CarServiceApiBuilder.getCarService()

            val yearDeferred = async { service.getCarsForYear(apiKey, searchText) }
            val transmissionDeferred = async { service.getCarsForTransmission(apiKey, searchText) }
            val fuelTypeDeferred = async { service.getCarsForFuelType(apiKey, searchText) }

            try {
                val yearResponse = yearDeferred.await()
                val transmissionResponse = transmissionDeferred.await()
                val fuelTypeResponse = fuelTypeDeferred.await()

                val carList = mutableListOf<Car>()

                if (yearResponse.isSuccessful) {
                    val yearCars = yearResponse.body()
                    yearCars?.let { carList.addAll(it) }
                }

                if (transmissionResponse.isSuccessful) {
                    val transmissionCars = transmissionResponse.body()
                    transmissionCars?.let { carList.addAll(it) }
                }

                if (fuelTypeResponse.isSuccessful) {
                    val fuelTypeCars = fuelTypeResponse.body()
                    fuelTypeCars?.let { carList.addAll(it) }
                }

                withContext(Dispatchers.Main) {
                    this@HomeViewModel.carList.value = carList
                }
            } catch (e: Exception) {
                // Handle exceptions
            }
        }
    }else{
           viewModelScope.launch {
               val service = CarServiceApiBuilder.getCarService()

               val yearDeferred = async { service.getCarsForYear(apiKey, "1996") }

               try {
                   val yearResponse = yearDeferred.await()


                   val carList = mutableListOf<Car>()

                   if (yearResponse.isSuccessful) {
                       val yearCars = yearResponse.body()
                       yearCars?.let { carList.addAll(it) }
                   }

                   withContext(Dispatchers.Main) {
                       this@HomeViewModel.carList.value = carList
                   }
               } catch (e: Exception) {
                   // Handle exceptions
               }
           }
       }
}}