package ar.edu.ort.tp3.appmobile_kotlin_carsapi.holders

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.R
import com.squareup.picasso.Picasso

class CarViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    private var view: View

    init {
        this.view = v
    }

    fun setMake(make: String) {
        val txt = this.view.findViewById<TextView>(R.id.tvHolderRCCarMakeAndModel)
        txt.text = make
    }
    fun setTransmission(transmission: String) {
        val txt = this.view.findViewById<TextView>(R.id.tvHolderRCCarTransmission)
        if (transmission == "a") {
            txt.text = "Automático"
        } else
            txt.text = "Manual"
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
        val limitedClase = if (clase.length <= 10) clase else clase.substring(0, 10)
        txt.text = limitedClase
    }

    fun setImage(make: String) {
        val imageView = view?.findViewById<ImageView>(R.id.ivHolderRCCarMakeAndModelLogo)
        if (make == "toyota") {
            imageView?.setImageResource(R.drawable.logo_toyota)
        }else if(make == "bmw"){
            imageView?.setImageResource(R.drawable.logo_bmw)
        }else if(make == "maserati"){
            imageView?.setImageResource(R.drawable.logo_maserati)
        } else if(make == "mercedes-benz"){
            imageView?.setImageResource(R.drawable.logo_mercedes)
        }else if(make == "porsche") {
            imageView?.setImageResource(R.drawable.logo_porsch)
        }else if(make == "alfa romeo"){
                imageView?.setImageResource(R.drawable.logo_alfa_romeo)
        }else if(make == "ferrari"){
            imageView?.setImageResource(R.drawable.logo_ferrari)
        }else if(make == "dodge"){
            imageView?.setImageResource(R.drawable.logo_dodge)
        }else if(make == "subaru"){
            imageView?.setImageResource(R.drawable.logo_subaru)
        }else if(make == "acura"){
            imageView?.setImageResource(R.drawable.logo_acura)
        }else if(make == "honda"){
            imageView?.setImageResource(R.drawable.logo_honda)
        }else if(make == "chevrolet"){
            imageView?.setImageResource(R.drawable.logo_chevrolet)
        }else if(make == "aston martin"){
            imageView?.setImageResource(R.drawable.logo_aston_martin)
        }
        else if(make == "audi"){
            imageView?.setImageResource(R.drawable.logo_audi)
        }



        else{
            imageView?.setImageResource(R.drawable.car_logo_flot)
        }

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