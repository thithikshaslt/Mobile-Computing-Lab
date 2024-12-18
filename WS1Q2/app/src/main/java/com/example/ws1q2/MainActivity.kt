package com.example.ws1q2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button)
        val tv = findViewById<TextView>(R.id.textView)
        val pic = findViewById<ImageView>(R.id.imageView)
        btn.setOnClickListener(){
            if(btn.text.toString() == "Eat Cookie"){
                btn.text = "Done"
                tv.text = "I'm so full"
                pic.setImageResource(R.drawable.full)
            }
            else{
                btn.text = "Eat Cookie"
                tv.text = "I'm so hungry"
                pic.setImageResource(R.drawable.hungry)
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}