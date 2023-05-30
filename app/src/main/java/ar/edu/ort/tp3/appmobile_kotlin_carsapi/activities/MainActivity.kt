package ar.edu.ort.tp3.appmobile_kotlin_carsapi.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.R
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.fragments.ProfileFragment
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.service.UserManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavView: BottomNavigationView
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var btnToolbarHamburger: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        val navController = navHostFragment.navController
        initListeners(navController)
        NavigationUI.setupWithNavController(bottomNavView, navController)
    }

    private fun initComponents() {
        supportActionBar?.hide()
        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        bottomNavView = findViewById(R.id.bottom_bar)
        btnToolbarHamburger = findViewById(R.id.btnToolbarHamburger)
        btnToolbarHamburger.backgroundTintList = ContextCompat.getColorStateList(this, R.color.black)
    }

    private fun initListeners(navController: NavController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.home) {
                btnToolbarHamburger.setBackgroundResource(R.drawable.hamburger)
            } else {
                btnToolbarHamburger.setBackgroundResource(R.drawable.back)
            }
        }
        btnToolbarHamburger.setOnClickListener {
            val intent = Intent(this, MyAccountActivity::class.java)
            startActivity(intent)
        }
    }
}
