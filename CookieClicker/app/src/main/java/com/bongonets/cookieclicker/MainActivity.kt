package com.bongonets.cookieclicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var currentScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_CookieClicker)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgCookie: ImageView = findViewById(R.id.imgCookie)
        var lblTotal: TextView = findViewById(R.id.lblTotal)

        imgCookie.setOnClickListener{
            currentScore++

            lblTotal.text = "${currentScore}"

            when {
                currentScore <= 5 -> {
                    imgCookie.setImageResource(R.drawable.cookie)
                }
                currentScore <= 10 -> {
                    imgCookie.setImageResource(R.drawable.qcookie)
                }
                currentScore in 11..19 -> {
                    imgCookie.setImageResource(R.drawable.hcookie)
                }
                currentScore > 20 -> {
                    imgCookie.setImageResource(com.google.android.material.R.drawable.navigation_empty_icon)
                    
                    Toast.makeText(this, "You ate it all!", Toast.LENGTH_LONG).show()
                    finish()
                }
            }
        }
    }
}