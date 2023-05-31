package ar.edu.ort.tp3.appmobile_kotlin_carsapi.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.R

class CarMakeViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    private var view: View

    init {
        this.view = v
    }

    fun setMake(make: String) {
        val txt = this.view.findViewById<TextView>(R.id.tvHolderRCHomeMake)
        txt.text = make

    }

    fun setImage(make: String) {
        val imageView = view?.findViewById<ImageView>(R.id.ivHolderRCHomeImage)
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