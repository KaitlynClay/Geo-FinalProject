package com.example.geo_finalproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class CorrectActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_correct)

        val nextBtn = findViewById<Button>(R.id.nextBtn)

        nextBtn.setOnClickListener(View.OnClickListener {
            finish()
        })
    }
}