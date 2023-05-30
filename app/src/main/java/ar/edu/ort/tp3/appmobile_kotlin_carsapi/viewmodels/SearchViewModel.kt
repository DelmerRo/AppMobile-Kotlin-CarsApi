package ar.edu.ort.tp3.appmobile_kotlin_carsapi.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.models.Car
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.service.CarServiceApiBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchViewModel : ViewModel() {
    val carList: MutableLiveData<List<Car>> = MutableLiveData()
    fun searchCars(searchText: String) {
        viewModelScope.launch {
            val service = CarServiceApiBuilder.getCarService()
            val carList = mutableListOf<Car>()
            try {
                val response =
                    service.getCars("VyFRiZ7J1W4Vbzuk89yLRA==qWOIgbFZ7H6YB8lI", searchText)
                if (response.isSuccessful) {
                    val cars = response.body()
                    cars?.let {
                        carList.addAll(cars)
                    }
                    withContext(Dispatchers.Main) {
                        this@SearchViewModel.carList.value = carList
                    }
                } else {
                    // Handle unsuccessful response
                }
            } catch (e: Exception) {
                // Handle exception
            }
        }
    }
}
