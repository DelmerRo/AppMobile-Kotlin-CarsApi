package ar.edu.ort.tp3.appmobile_kotlin_carsapi.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.models.Car
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.service.CarServiceApiBuilder
import kotlinx.coroutines.launch

class CarsViewModel : ViewModel() {
    val carList: MutableLiveData<List<Car>> = MutableLiveData()
    private var apiKey = "VyFRiZ7J1W4Vbzuk89yLRA==qWOIgbFZ7H6YB8lI"
    fun searchCars(searchText: String) {
        viewModelScope.launch {
            val service = CarServiceApiBuilder.getCarService()
            val carList = mutableListOf<Car>()
            try {
                val response = service.getCarsForMake(apiKey, searchText)
                if (response.isSuccessful) {
                    val cars = response.body()
                    cars?.let {
                        carList.addAll(cars)
                    }
                    this@CarsViewModel.carList.value = carList
                } else {
                    // Handle unsuccessful response
                }
            } catch (e: Exception) {
                // Handle exception
            }
        }
    }
}