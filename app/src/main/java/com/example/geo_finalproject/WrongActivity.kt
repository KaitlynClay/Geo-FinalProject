package com.example.geo_finalproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class WrongActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wrong)

        val corAnswertxt = findViewById<TextView>(R.id.corAnswerTxt)
        val nextBtn = findViewById<Button>(R.id.nextBtn)
        val corAnswer = getIntent().getStringExtra("correct_answer")

        corAnswertxt.setText(corAnswer)

        nextBtn.setOnClickListener(View.OnClickListener {
            finish()
        })

    }
}