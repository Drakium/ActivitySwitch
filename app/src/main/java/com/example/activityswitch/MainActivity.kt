package com.example.activityswitch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSwitch = findViewById<Button>(R.id.button)
        btnSwitch.setOnClickListener {
            openDrawCanvas()
        }
    }
    fun openDrawCanvas(){
        intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }
}