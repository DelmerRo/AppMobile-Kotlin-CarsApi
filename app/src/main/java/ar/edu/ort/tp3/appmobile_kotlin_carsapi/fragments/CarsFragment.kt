package ar.edu.ort.tp3.appmobile_kotlin_carsapi.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.R
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.adapters.CarAdapter
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.models.Car
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.models.CarPaginateResponse
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.service.CarServiceApiBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarsFragment : Fragment() {
    private lateinit var carAdapter: CarAdapter
    private lateinit var recyclerViewCars: RecyclerView
    private lateinit var etCarsSearch: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cars, container, false)
        etCarsSearch = view.findViewById(R.id.etCarsSearch)
        return view
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewCars = view.findViewById(R.id.rvCars)
        recyclerViewCars.layoutManager = LinearLayoutManager(requireContext())
        carAdapter = CarAdapter(emptyList())
        recyclerViewCars.adapter = carAdapter
        CoroutineScope(Dispatchers.Main).launch {
            loadCars()
        }

    }

    private suspend fun loadCars() {
        val service = CarServiceApiBuilder.getCarService()
        val carList = mutableListOf<Car>()
        try {
            val response = service.getCars("VyFRiZ7J1W4Vbzuk89yLRA==qWOIgbFZ7H6YB8lI", "camry")
            if (response.isSuccessful) {
                Log.e("dff", response.body().toString())
                val cars = response.body()
                cars?.let {
                    carList.addAll(cars)
                }
                withContext(Dispatchers.Main) {
                    showData(carList)
                }
            } else {
                // Manejar respuesta no exitosa aquí si es necesario
            }
        } catch (e: Exception) {
            Log.e("CAtch", e.toString())
            // Manejar excepción aquí si es necesario
        }
    }
    private fun showData(carList: List<Car>) {
        Log.e("showData",carList.toString())
        carAdapter = CarAdapter(carList)
        recyclerViewCars.adapter = carAdapter
    }
}

