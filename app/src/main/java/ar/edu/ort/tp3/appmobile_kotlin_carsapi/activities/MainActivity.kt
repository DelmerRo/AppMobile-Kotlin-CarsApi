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
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var tvNavHeaderMain: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("EnONcreate", "EnONcreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        setupDrawerLayout()

    }
    /*
        override fun onCreateOptionsMenu(menu: Menu): Boolean {
            Log.d("onCreateOptionsMenu","fsdfds")
            menuInflater.inflate(R.menu.basic_menu, menu)
            return true
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            Log.d("DEBUG", "item id: ${item.itemId}")
            return when (item.itemId) {
                R.id.salir -> {
                    Log.d("DEBUG", "exit clicked")
                    finishAffinity() // Finaliza la actividad actual y todas las actividades secundarias
                    true
                }
                else -> super.onOptionsItemSelected(item)
            }
        }*/

    private fun initComponents() {
        // Busco y guardo la referencia a las vistas en variables
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        tvNavHeaderMain = navigationView.getHeaderView(0).findViewById(R.id.tvNavHeaderMain)
        updateNameUser(tvNavHeaderMain)
    }

    private fun updateNameUser(tvNavHeaderMain: TextView) {
        val email: String = intent.extras?.getString("EXTRA_NAME").orEmpty()
        tvNavHeaderMain.text = email
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
            supportActionBar?.setHomeAsUpIndicator(R.drawable.hamburger)

        }
    }

    // Habilita la navegación desde la appbar con el drawer. Deja
//    override fun onSupportNavigateUp(): Boolean {
//        return NavigationUI.navigateUp(navHostFragment.navController, drawerLayout)
//    }

    // Forzar el drawer a que se abra siempre
    override fun onSupportNavigateUp(): Boolean {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        return false
    }
}