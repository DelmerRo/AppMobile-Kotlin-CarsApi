package ar.edu.ort.tp3.appmobile_kotlin_carsapi.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
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
        initComponents()
        val navController = navHostFragment.navController
        initListeners(navController)
        NavigationUI.setupWithNavController(bottomNavView, navController)
    }

    private fun initComponents() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        bottomNavView = findViewById(R.id.bottom_bar)
        btnToolbarHamburger = findViewById(R.id.btnToolbarHamburger)
        btnToolbarHamburger.setBackgroundTintList(
            ContextCompat.getColorStateList(
                this,
                R.color.black
            )
        )
    }

    private fun initListeners(navController: NavController) {
        // Agregar un OnDestinationChangedListener al NavController
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.home) {
                btnToolbarHamburger.setBackgroundResource(R.drawable.hamburger)
            } else {
                btnToolbarHamburger.setBackgroundResource(R.drawable.back)
            }
        }
    }
}
