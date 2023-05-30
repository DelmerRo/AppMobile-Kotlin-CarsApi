package ar.edu.ort.tp3.appmobile_kotlin_carsapi.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.R
import com.google.android.material.navigation.NavigationView

class MyAccountActivity : AppCompatActivity() {
    private lateinit var hamburgerButton: Button
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var tvNavHeaderMain: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_account)
        initComponents()
        initListeners()
    }

    private fun initListeners() {
        setupDrawerLayout()
    }

    private fun initComponents() {
        // Busco y guardo la referencia a las vistas en variables
        drawerLayout = findViewById(R.id.drawer_layout_left)
        navigationView = findViewById(R.id.nav_view_left)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        tvNavHeaderMain = navigationView.getHeaderView(0).findViewById(R.id.tvNavHeaderMain)
        updateNameUser(tvNavHeaderMain)
        hamburgerButton.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.black));
    }

    private fun updateNameUser(tvNavHeaderMain: TextView) {
       // val email: String = intent.extras?.getString("EXTRA_NAME").orEmpty()
       // tvNavHeaderMain.text = email
    }

    private fun setupDrawerLayout() {

        val navController = navHostFragment.navController
        // Vinculo la navegación del drawer con la del graph
        navigationView.setupWithNavController(navController)

        // Configuro la appbar para que muestre el icono del drawer y actualice el titulo
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

        // Listener para cuando se realiza la navegacion
        navController.addOnDestinationChangedListener { _, _, _ ->

            // Aca le digo que quiero que mi icono izquierdo de la appbar sea el del drawer
            supportActionBar?.setHomeAsUpIndicator(R.drawable.hamburger)

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        return false
    }
}