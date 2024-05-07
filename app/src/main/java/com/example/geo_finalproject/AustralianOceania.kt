package com.example.geo_finalproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.Random

class AustralianOceania : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_australian_oceania)

        val ranFactTxt = findViewById<TextView>(R.id.ranFactTxt)
        val facts = listOf("Australia is the world's smallest continent and the sixth-largest country by land area.",
            "The Great Barrier Reef, located off the coast of Queensland, Australia, is the largest coral reef system in the world.",
            "Oceania comprises thousands of islands, including the islands of the Pacific Ocean and the continent of Australia.",
            "New Zealand is known for its stunning landscapes, including fjords, mountains, and geothermal areas.",
            "The Maori people are the indigenous Polynesian people of New Zealand, known for their rich culture and traditions.",
            "Papua New Guinea is one of the most linguistically diverse countries in the world, with over 800 languages spoken.",
            "Australia is home to unique wildlife, including kangaroos, koalas, and the iconic Tasmanian devil.",
            "Oceania has a strong tradition of oceanic navigation and exploration by indigenous peoples, such as the Polynesians.",
            "The indigenous Aboriginal peoples of Australia have a history and culture dating back tens of thousands of years.",
            "The Pacific Islands face challenges such as climate change, rising sea levels, and environmental degradation.")

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
            intent.putExtra("category", 7)
            startActivity(intent)
        }
    }
}