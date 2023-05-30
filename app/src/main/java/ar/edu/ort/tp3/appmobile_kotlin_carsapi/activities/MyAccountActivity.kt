package ar.edu.ort.tp3.appmobile_kotlin_carsapi.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.R
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.data.UserData
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.service.UserManager
import com.google.android.material.navigation.NavigationView
import com.squareup.picasso.Picasso

class MyAccountActivity : AppCompatActivity() {
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var tvNavHeaderMain: TextView
    private lateinit var ivPhoto: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_account)
        //supportActionBar?.hide()
        initComponents()
        updateNameUser()
        initListeners()
    }

    private fun initListeners() {
        setupDrawerLayout()
        drawerLayout.openDrawer(GravityCompat.START)
    }

    private fun initComponents() {
        drawerLayout = findViewById(R.id.drawer_layout_left)
        navigationView = findViewById(R.id.nav_view_left)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        tvNavHeaderMain = navigationView.getHeaderView(0).findViewById(R.id.tvNavHeaderMain)
        ivPhoto = navigationView.getHeaderView(0).findViewById(R.id.ivNavHeaderPhoto)
    }

    private fun updateNameUser() {
        val userOnline = UserManager.user
        if (userOnline != null) {
            tvNavHeaderMain.text = userOnline.getNamLastNam()
            Picasso.get().load(userOnline.getUrlImage()).into(ivPhoto)
        }
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

