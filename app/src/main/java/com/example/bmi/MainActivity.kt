package com.example.bmi

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val Weight : EditText = findViewById(R.id.we)
        val Height : EditText = findViewById(R.id.he)
        val Calc : Button = findViewById(R.id.button)
        val bmi : TextView = findViewById(R.id.bmi)
        Calc.setOnClickListener {
            val weightText = Weight.text.toString()
            val heightText = Height.text.toString()
            val weight = weightText.toDouble()
            val height = heightText.toDouble()

            val res = calculateBMI(weight, height)
            bmi.text = "Your BMI: $res"
        }
    }
    private fun calculateBMI(weight: Double, height: Double): Double {
        return weight / (height * height)
    }
}