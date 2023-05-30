package ar.edu.ort.tp3.appmobile_kotlin_carsapi.fragments

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
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
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.service.CarServiceApiBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CarsFragment : Fragment() {
    private lateinit var carAdapter: CarAdapter
    private lateinit var recyclerViewCars: RecyclerView
    private lateinit var etCarsSearch: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cars, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewCars = view.findViewById(R.id.rvCars)
        recyclerViewCars.layoutManager = LinearLayoutManager(requireContext())
        carAdapter = CarAdapter(emptyList())
        recyclerViewCars.adapter = carAdapter
        etCarsSearch = view.findViewById(R.id.etCarsSearch)

        etCarsSearch.setOnKeyListener { _, keyCode, event ->
            // Log.e(EditorInfo.IME_ACTION_SEARCH.toString(),actionId.toString())
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN) {
                val searchText = etCarsSearch.text.toString().trim()
                CoroutineScope(Dispatchers.Main).launch {
                    loadCars(searchText)
                }
                true
            } else {
                false
            }
        }

    }


    private suspend fun loadCars(searchText: String) {
        val service = CarServiceApiBuilder.getCarService()
        val carList = mutableListOf<Car>()
        try {
            val response = service.getCars("VyFRiZ7J1W4Vbzuk89yLRA==qWOIgbFZ7H6YB8lI", searchText)
            if (response.isSuccessful) {
                val cars = response.body()
                cars?.let {
                    carList.addAll(cars)
                }
                withContext(Dispatchers.Main) {
                    showData(carList)
                }
            } else {
                Log.e("response.isSuccessful", "No se encontró respuesta en la respuesta!")
            }
        } catch (e: Exception) {
            Log.e("Catch", e.toString())
        }
    }

    private fun showData(carList: List<Car>) {
        carAdapter = CarAdapter(carList)
        recyclerViewCars.adapter = carAdapter
    }
}

