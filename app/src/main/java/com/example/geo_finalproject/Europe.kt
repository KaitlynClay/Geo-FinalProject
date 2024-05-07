package com.example.geo_finalproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.Random

class Europe : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_europe)

        val ranFactTxt = findViewById<TextView>(R.id.ranFactTxt)
        val facts = listOf("Europe is the second-smallest continent by land area, but it has the third-largest population.",
            "The European Union, a political and economic union of 27 member states, has its headquarters in Brussels, Belgium.",
            "The Vatican City, located within Rome, Italy, is the smallest independent state in the world.",
            "The Mediterranean Sea, bordered by Europe, Africa, and Asia, has been a vital trade route throughout history.",
            "The Renaissance, a period of great cultural and artistic achievements, originated in Europe in the 14th century.",
            "Europe has a rich history of monarchies, with several countries still retaining royal families.",
            "The Alps, the highest and most extensive mountain range system in Europe, stretch across several countries including France, Italy, Switzerland, Austria, and Germany.",
            "Europe has a diverse range of languages, with over 200 indigenous languages spoken.",
            "The Industrial Revolution, which began in Britain in the late 18th century, transformed economies and societies across Europe.",
            "The European Space Agency, headquartered in Paris, France, is a leading organization in space exploration and research.")

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
            intent.putExtra("category", 3)
            startActivity(intent)
        }
    }
}