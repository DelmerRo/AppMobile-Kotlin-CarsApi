package ar.edu.ort.tp3.appmobile_kotlin_carsapi.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavView: BottomNavigationView
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var btnToolbarHamburger: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        bottomNavView = findViewById(R.id.bottom_bar)
        btnToolbarHamburger = findViewById(R.id.btnToolbarHamburger)


        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(bottomNavView, navController)

        // Agregar un OnDestinationChangedListener al NavController
        navController.addOnDestinationChangedListener { _, destination, _ ->
            // Verificar el destino actual
            if (destination.id == R.id.home) {
                // Cambiar la imagen del hamburguesa a la imagen deseada para el Fragmento 1
                btnToolbarHamburger.setBackgroundResource(R.drawable.hamburger)
            } else {
                // Restaurar la imagen del hamburguesa predeterminada para otros fragmentos
                btnToolbarHamburger.setBackgroundResource(R.drawable.back)
            }
        }
    }
}
