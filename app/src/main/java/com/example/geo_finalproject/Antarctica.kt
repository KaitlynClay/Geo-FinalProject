package com.example.geo_finalproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.Random

class Antarctica : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_antarctica)

        val ranFactTxt = findViewById<TextView>(R.id.ranFactTxt)
        val facts = listOf("Antarctica is the coldest, windiest, and driest continent on Earth.",
            "It's the only continent without a native human population, although scientists and support staff inhabit research stations temporarily.",
            "The Antarctic ice sheet contains about 70% of the world's fresh water and 90% of the world's ice.",
            "The South Pole, located at the southernmost point of the Earth, experiences six months of continuous daylight and six months of darkness")

        val random = Random()
        val randomFact = facts[random.nextInt(facts.size)]
        ranFactTxt.text = randomFact

        val btnHome = findViewById<Button>(R.id.idBtnHome)
        btnHome.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        val btnQuestion = findViewById<Button>(R.id.idQuestionBtn)
        btnQuestion.setOnClickListener {
            val intent = Intent(this, DisplayQuestions::class.java)
            intent.putExtra("category", 6)
            startActivity(intent)
        }
    }
}