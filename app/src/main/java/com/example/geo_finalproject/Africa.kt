package com.example.geo_finalproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.Random

class Africa : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_africa)

        val ranFactTxt = findViewById<TextView>(R.id.ranFactTxt)
        val facts = listOf("Africa is the second-largest continent in the world by both land area and population.",
            "The Sahara Desert, the world's largest hot desert, covers much of North Africa.",
            "The Nile River, the longest river in the world, runs through eleven countries in Africa.",
            "Africa is the most linguistically diverse continent, with over 2,000 languages spoken.",
            "The African Great Lakes region contains some of the deepest lakes in the world, including Lake Tanganyika.",
            "The Serengeti National Park in Tanzania hosts the largest terrestrial mammal migration in the world.",
            "The Democratic Republic of the Congo is home to the second-largest rainforest in the world after the Amazon.",
            "Africa has a rich cultural heritage, with diverse traditions, music, art, and cuisine.",
            "The continent is experiencing rapid urbanization and economic growth in many regions, although challenges such as poverty, disease, and political instability persist.")

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
            intent.putExtra("category", 5)
            startActivity(intent)
        }
    }
}