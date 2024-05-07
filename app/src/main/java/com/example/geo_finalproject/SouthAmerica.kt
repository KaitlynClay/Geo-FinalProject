package com.example.geo_finalproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.Random

class SouthAmerica : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_southamerica)

        val ranFactTxt = findViewById<TextView>(R.id.ranFactTxt)
        val facts = listOf("The Amazon Rainforest, primarily located in Brazil, is the largest tropical rainforest in the world.",
            "Angel Falls in Venezuela is the highest uninterrupted waterfall in the world, with a height of 979 meters (3,212 feet).",
            "South America is home to the Andes, the longest mountain range in the world.",
            "The Galápagos Islands, a province of Ecuador, played a crucial role in Charles Darwin's theory of evolution by natural selection.",
            "The Atacama Desert in Chile is one of the driest places on Earth.",
            "The largest carnival in the world, the Rio Carnival, takes place annually in Rio de Janeiro, Brazil.",
            "Lake Titicaca, located on the border of Peru and Bolivia, is one of the highest navigable lakes in the world.",
            "South America has the largest river by discharge volume, the Amazon River.",
            "Machu Picchu, an ancient Inca citadel in Peru, is one of the New Seven Wonders of the World.",
            "South America has a rich cultural heritage with influences from indigenous civilizations like the Inca, Maya, and Aztec, as well as European colonization.")

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
            intent.putExtra("category", 2)
            startActivity(intent)
        }
    }
}