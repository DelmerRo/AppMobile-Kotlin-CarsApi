package ar.edu.ort.tp3.appmobile_kotlin_carsapi.holders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.R

class CarViewHolder(v: View): RecyclerView.ViewHolder(v) {
    private var view: View

    init {
        this.view = v
    }
    fun setMakeModel(make: String,model: String){
        val txt = this.view.findViewById<TextView>(R.id.tvHolderRCCarMakeAndModel)
        txt.text = "$make $model"
    }

    fun setTransmission(transmission: String) {
        val txt = this.view.findViewById<TextView>(R.id.tvHolderRCCarTransmission)

        txt.text = if (transmission == "a") "Automático" else "Manual"
    }

    fun setFuelType(fuelType: String) {
        val txt = this.view.findViewById<TextView>(R.id.tvHolderRCCarFuelType)
        txt.text = fuelType
    }

    fun setYear(year: Int) {
        val txt = this.view.findViewById<TextView>(R.id.tvHolderRCCarYear)
        txt.text = year.toString()
    }

    fun setClase(clase: String) {
        val txt = this.view.findViewById<TextView>(R.id.tvHolderRCCarClass)
        txt.text = clase
    }
}
/*
    fun setMake(make: Int){
        val txt = this.view.findViewById<TextView>(R.id.tvHolderRCCarMake)
        txt.text = make.toString()
    }

    fun setModel(model: String){
        val txt = this.view.findViewById<TextView>(R.id.tvHolderRCCarModel)
        txt.text = model
    }

   /* fun setCityMpg(cityMpg: Int){
        val txt = this.view.findViewById<TextView>(R.id.tvHolderRCCarCityMpg)
        txt.text = cityMpg.toString()
    }*/

    /*fun setCombinationMpg(combination_mpg: Int){
        val txt = this.view.findViewById<TextView>(R.id.tvHolderRCCarCombinationMpg)
        txt.text = combination_mpg.toString()
    }
    fun setCylinders(cylinders: Int){
        val txt = this.view.findViewById<TextView>(R.id.tvHolderRCCarCylinders)
        txt.text = cylinders.toString()
    }*/
    /*fun setDisplacement(displacement: String){
        val txt = this.view.findViewById<TextView>(R.id.tvHolderRCCarDisplacement)
        txt.text = displacement
    }*/
    /*fun setDrive(drive: String){
        val txt = this.view.findViewById<TextView>(R.id.tvHolderRCCarDrive)
        txt.text = drive
    }*/

    /*fun setHighwayMpg(highwayMpg: Int){
        val txt = this.view.findViewById<TextView>(R.id.tvHolderRCCarHighwayMpg)
        txt.text = highwayMpg.toString()
    }

    fun setModel(model: String){
        val txt = this.view.findViewById<TextView>(R.id.tvHolderRCCarModel)
        txt.text = model
    }
*/