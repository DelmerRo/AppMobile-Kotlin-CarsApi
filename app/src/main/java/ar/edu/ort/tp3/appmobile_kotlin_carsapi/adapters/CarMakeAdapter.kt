package ar.edu.ort.tp3.appmobile_kotlin_carsapi.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.R
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.holders.CarMakeViewHolder
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.holders.CarViewHolder
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.models.Car

class CarMakeAdapter (private val carList: List<Car>) : RecyclerView.Adapter<CarMakeViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarMakeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.make_row, parent, false)
        return CarMakeViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarMakeViewHolder, position: Int) {
        val car = carList[position]
        holder.setMake(car.make)
        holder.setImage(car.make)
    }

    override fun getItemCount(): Int {
        return carList.size
    }
}