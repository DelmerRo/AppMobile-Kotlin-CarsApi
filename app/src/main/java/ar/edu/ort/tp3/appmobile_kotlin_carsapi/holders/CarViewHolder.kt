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
        when (make) {
            "toyota" -> imageView?.setImageResource(R.drawable.logo_toyota)
            "bmw" -> imageView?.setImageResource(R.drawable.logo_bmw)
            "maserati" -> imageView?.setImageResource(R.drawable.logo_maserati)
            "mercedes-benz" -> imageView?.setImageResource(R.drawable.logo_mercedes)
            "porsche" -> imageView?.setImageResource(R.drawable.logo_porsch)
            "alfa romeo" -> imageView?.setImageResource(R.drawable.logo_alfa_romeo)
            "ferrari" -> imageView?.setImageResource(R.drawable.logo_ferrari)
            "dodge" -> imageView?.setImageResource(R.drawable.logo_dodge)
            "subaru" -> imageView?.setImageResource(R.drawable.logo_subaru)
            "acura" -> imageView?.setImageResource(R.drawable.logo_acura)
            "honda" -> imageView?.setImageResource(R.drawable.logo_honda)
            "chevrolet" -> imageView?.setImageResource(R.drawable.logo_chevrolet)
            "aston martin" -> imageView?.setImageResource(R.drawable.logo_aston_martin)
            "audi" -> imageView?.setImageResource(R.drawable.logo_audi)
            else -> imageView?.setImageResource(R.drawable.car_logo_flot)
        }

    }
}
