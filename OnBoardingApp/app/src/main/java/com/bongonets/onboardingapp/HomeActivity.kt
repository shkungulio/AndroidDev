package com.bongonets.onboardingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_DearSantaTwo)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnExit = findViewById<Button>(R.id.btnExit)
        btnExit.setOnClickListener {
            Toast.makeText(this, "Thank your for trying our App", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}