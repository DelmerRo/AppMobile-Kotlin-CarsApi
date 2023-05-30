package ar.edu.ort.tp3.appmobile_kotlin_carsapi

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.R
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.activities.MainActivity
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.data.UserData


class Login : AppCompatActivity() {
    private lateinit var etUserName: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()
        val myButton = findViewById<Button>(R.id.btnLogin)
        initComponent()
        initListeners()
    }

    @RequiresApi(Build.VERSION_CODES.P)
    private fun initListeners() {
        btnLogin.setOnClickListener {
            val email = etUserName.text.toString()
            val password = etPassword.text.toString()
            val getSearchUser = getSearchedUser(email.toUpperCase(), password.toUpperCase())
            Log.d("Usuario", UserData.getUser()[0].getEmail())
            if (getSearchUser != null) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("EXTRA_MY_OBJECT", getSearchUser)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun getSearchedUser(email: String, password: String): UserData? {
        var i = 0
        var user: UserData? = null
        val users = UserData.getUser()
        while (i < users.size && user == null) {
            Log.d("Usuario", users[i].toString())
            if (users[i].getEmail().toUpperCase() == email && users[i].getPassword() == password) {
                user = users[i]
            } else {
                i++
            }
        }
        return user
    }

    private fun initComponent() {
        etUserName = findViewById(R.id.editTextTextEmailAddress)
        etPassword = findViewById(R.id.editTextTextPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnLogin.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.btn_brand_black));
    }
}
