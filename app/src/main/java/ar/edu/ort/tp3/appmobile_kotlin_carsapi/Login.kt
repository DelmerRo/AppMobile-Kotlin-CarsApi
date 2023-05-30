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
}

