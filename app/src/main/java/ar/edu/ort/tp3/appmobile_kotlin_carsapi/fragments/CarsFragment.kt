package ar.edu.ort.tp3.appmobile_kotlin_carsapi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.R
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.adapters.CarAdapter
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.models.Car
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.viewmodels.CarsViewModel

class CarsFragment : Fragment() {
    private lateinit var carAdapter: CarAdapter
    private lateinit var recyclerViewCars: RecyclerView
    private lateinit var etCarsSearch: EditText
    private lateinit var carsViewModel: CarsViewModel
    private var marcaAMostrar = "Toyota"
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

        carsViewModel = ViewModelProvider(this)[CarsViewModel::class.java]
        val navController = findNavController()
        etCarsSearch.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                navController.navigate(R.id.action_cars_to_search3)
                etCarsSearch.clearFocus()
            }
        }
        carsViewModel.carList.observe(viewLifecycleOwner) { carList ->
            showData(carList)
        }
        carsViewModel.searchCars(marcaAMostrar)
    }

    private fun showData(carList: List<Car>) {
        carAdapter = CarAdapter(carList)
        recyclerViewCars.adapter = carAdapter
    }
}



