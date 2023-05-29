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
        //holder .setCityMpg(car.city_mpg)
       // holder .setCarClass(car.`class`)
       // holder .setCombinationMpg(car.combination_mpg)
       // holder  .setCylinders(car.cylinders)
       // holder .setDisplacement(car.displacement)
       // holder .setDrive(car.drive)
        holder .setFuelType(car.fuel_type)
     //   holder .setHighwayMpg(car.highway_mpg)
        holder.setMakeModel(car.make,car.model)
        holder .setTransmission(car.transmission)
        holder .setYear(car.year)
        holder.setClase(car.`class`)
    }

    override fun getItemCount(): Int {
        return carList.size
    }


}