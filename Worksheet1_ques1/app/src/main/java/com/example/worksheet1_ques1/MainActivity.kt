package com.example.worksheet1_ques1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val field1 = findViewById<TextView>(R.id.editTextText)
        val field2 = findViewById<TextView>(R.id.editTextText2)

        val but1 = findViewById<Button>(R.id.button)
        but1.setOnClickListener({
            if(field1.text.toString() == "" && field2.text.toString() != ""){
                val cel = field2.text.toString().toFloat()
                val fah = (cel*9)/5 + 32
                field1.text = String.format(fah.toString())
            }
            if(field2.text.toString() == "" && field1.text.toString() != ""){
                val fah = field1.text.toString().toFloat()
                val cel = (fah-32)*5/9
                field2.text = String.format(cel.toString())
            }
            else{
                Toast.makeText(applicationContext, "Enter input at one place only", Toast.LENGTH_LONG).show()
            }
                    })
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}