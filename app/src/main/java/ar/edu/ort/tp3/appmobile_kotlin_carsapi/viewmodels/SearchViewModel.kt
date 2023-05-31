package ar.edu.ort.tp3.appmobile_kotlin_carsapi.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.models.Car
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.service.CarServiceApiBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchViewModel : ViewModel() {
    val carList: MutableLiveData<List<Car>> = MutableLiveData()
    private var apiKey = "VyFRiZ7J1W4Vbzuk89yLRA==qWOIgbFZ7H6YB8lI"
    fun searchCars(searchText: String) {
        viewModelScope.launch {
            val service = CarServiceApiBuilder.getCarService()

            val carsDeferred = async { service.getCarsForMake(apiKey, searchText) }
            val yearDeferred = async { service.getCarsForYear(apiKey, searchText) }
            val transmissionDeferred = async { service.getCarsForTransmission(apiKey, searchText) }
            val fuelTypeDeferred = async { service.getCarsForFuelType(apiKey, searchText) }

            try {
                val carsResponse = carsDeferred.await()
                val yearResponse = yearDeferred.await()
                val transmissionResponse = transmissionDeferred.await()
                val fuelTypeResponse = fuelTypeDeferred.await()

                val carList = mutableListOf<Car>()

                if (carsResponse.isSuccessful) {
                    val cars = carsResponse.body()
                    cars?.let { carList.addAll(it) }
                }

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
                    this@SearchViewModel.carList.value = carList
                }
            } catch (e: Exception) {
                // Handle exceptions
            }
        }
    }
}

