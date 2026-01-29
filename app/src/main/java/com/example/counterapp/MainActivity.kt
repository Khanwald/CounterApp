package com.example.counterapp

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isInvisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var counter = 0
        val counter_txt = findViewById<TextView>(R.id.counter_txt)
        val button = findViewById<Button>(R.id.counter_button)
        val double_button = findViewById<Button>(R.id.double_button)
        button.setOnClickListener {
            counter++
            //Toast.makeText(it.context, "Clicked Button!", Toast.LENGTH_SHORT).show()
            counter_txt.text = "$counter"
            if (counter >= 100) {


                double_button.visibility = View.VISIBLE
                double_button.setOnClickListener {
                    button.text = "Add 2"

                    button.setOnClickListener {
                        counter += 2
                        counter_txt.text = "$counter"
                    }
                    double_button.visibility = View.INVISIBLE
                }
            }
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}