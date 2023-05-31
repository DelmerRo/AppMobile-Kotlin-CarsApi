package ar.edu.ort.tp3.appmobile_kotlin_carsapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.core.content.ContextCompat
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.activities.MainActivity
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.activities.MyAccountActivity
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.data.UserData
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.service.UserManager


class Login : AppCompatActivity() {
    private lateinit var etUserName: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()
        initComponent()
        initListeners()
    }

    private fun initListeners() {
        btnLogin.setOnClickListener {
            val email = etUserName.text.toString()
            val password = etPassword.text.toString()
            val getSearchUser = getSearchedUser(email.toUpperCase(), password.toUpperCase())
            if (getSearchUser != null) {
                UserManager.user = getSearchUser
                val intent = Intent(this, MainActivity::class.java)
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
        btnLogin.backgroundTintList = ContextCompat.getColorStateList(this, R.color.btn_brand_black);
    }
}
