package ar.edu.ort.tp3.appmobile_kotlin_carsapi

import android.annotation.SuppressLint
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.activities.MainActivity


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.R.id.btnLogin
import ar.edu.ort.tp3.appmobile_kotlin_carsapi.R.layout.activity_login


class LoginActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_login)

        var btnLogin = findViewById<Button>(btnLogin)
        btnLogin.setOnClickListener {
            startActivity(Intent(this , MainActivity::class.java) );
            finish()
        }
    }

//algo
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
        btnLogin.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.black));
    }

}

