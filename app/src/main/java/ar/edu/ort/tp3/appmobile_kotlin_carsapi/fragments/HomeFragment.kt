package ar.edu.ort.tp3.appmobile_kotlin_carsapi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.R
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.adapters.CarMakeAdapter
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.models.Car
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.viewmodels.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var carMakeAdapter: CarMakeAdapter
    private lateinit var recyclerViewCars: RecyclerView
    private lateinit var svHomeSearch: SearchView
    private val homeViewModel: HomeViewModel by lazy {
        ViewModelProvider(requireActivity())[HomeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponents(view)
        initListeners()
    }

    private fun initComponents(view: View) {
        recyclerViewCars = view.findViewById(R.id.rvMake)
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerViewCars.layoutManager = layoutManager
        carMakeAdapter = CarMakeAdapter(emptyList())
        recyclerViewCars.adapter = carMakeAdapter
        homeViewModel.searchCars("0")
        svHomeSearch = view.findViewById(R.id.svHomeSearch)
    }

    private fun initListeners() {
        svHomeSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                val searchText = query.trim()
                homeViewModel.searchCars(searchText)
                return true
            }
            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })

        homeViewModel.carList.observe(viewLifecycleOwner, Observer { carList ->
            showData(carList)
        })
    }

    private fun showData(carList: List<Car>) {
        carMakeAdapter = CarMakeAdapter(carList)
        recyclerViewCars.adapter = carMakeAdapter
    }
}