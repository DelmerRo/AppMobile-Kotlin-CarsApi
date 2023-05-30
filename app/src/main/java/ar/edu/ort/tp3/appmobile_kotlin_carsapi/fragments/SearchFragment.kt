package ar.edu.ort.tp3.appmobile_kotlin_carsapi.fragments

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.R
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.adapters.CarAdapter
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.models.Car
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.viewmodels.SearchViewModel

class SearchFragment : Fragment() {

    private lateinit var carAdapter: CarAdapter
    private lateinit var recyclerViewCars: RecyclerView
    private lateinit var etCarsSearch: EditText
    private val searchViewModel: SearchViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponents(view)
        initListeners()

    }

    private fun initComponents(view: View) {
        recyclerViewCars = view.findViewById(R.id.rvCars)
        recyclerViewCars.layoutManager = LinearLayoutManager(requireContext())
        carAdapter = CarAdapter(emptyList())
        recyclerViewCars.adapter = carAdapter
        etCarsSearch = view.findViewById(R.id.etCarsSearch)
    }

    private fun initListeners() {
        etCarsSearch.setOnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN) {
                val searchText = etCarsSearch.text.toString().trim()
                searchViewModel.searchCars(searchText)
                true
            } else {
                false
            }
        }
        searchViewModel.carList.observe(viewLifecycleOwner, Observer { carList ->
            showData(carList)
        })
    }

    private fun showData(carList: List<Car>) {
        carAdapter = CarAdapter(carList)
        recyclerViewCars.adapter = carAdapter
    }
}

