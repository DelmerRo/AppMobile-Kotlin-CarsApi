package ar.edu.ort.tp3.appmobile_kotlin_carsapi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.R



class ProfileFragment : Fragment() {
    private lateinit var buttonBack: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_profile, container, false)
        initListeners(vista)
        return vista;
    }


    private fun initListeners(vista: View) {
        buttonBack = vista.findViewById(R.id.ivHamburger)
        buttonBack.setOnClickListener {
           // val action = ProfileFragment.
            //findNavController().navigate(action)
        }
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonBack = view.findViewById(R.id.ivHamburger)



    }

}