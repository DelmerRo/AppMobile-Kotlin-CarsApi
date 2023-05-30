package ar.edu.ort.tp3.appmobile_kotlin_carsapi.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.R
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.holders.CarViewHolder
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.models.Car

class CarAdapter (private val carList: List<Car>) : RecyclerView.Adapter<CarViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.car_row, parent, false)
        return CarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = carList[position]
        holder .setFuelType(car.fuel_type)
        holder.setMake(car.make)
        holder .setTransmission(car.transmission)
        holder .setYear(car.year)
        holder.setClase(car.`class`)
        holder.setImage(car.make)
    }

    override fun getItemCount(): Int {
        return carList.size
    }


}