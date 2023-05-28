package ar.edu.ort.tp3.appmobile_kotlin_carsapi.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNaView : BottomNavigationView
    private lateinit var navHostFragment : NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        bottomNaView = findViewById(R.id.bottom_bar)

        NavigationUI.setupWithNavController(bottomNaView,navHostFragment.navController)
    }


}