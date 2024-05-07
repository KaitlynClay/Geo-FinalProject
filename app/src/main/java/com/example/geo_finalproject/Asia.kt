package com.example.geo_finalproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.Random

class Asia : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asia)

        val ranFactTxt = findViewById<TextView>(R.id.ranFactTxt)
        val facts = listOf("Asia is the largest continent in the world by both land area and population.",
            "Mount Everest, the highest point on Earth, is located in the Himalayas on the border between Nepal and China.",
            "The Great Wall of China is one of the most impressive architectural feats in history, stretching over 13,000 miles (21,196 kilometers).",
            "Asia is home to some of the oldest civilizations, including those in Mesopotamia, the Indus Valley, and China.",
            "The Silk Road, an ancient network of trade routes, connected Asia with Europe and Africa.",
            "Asia is incredibly diverse, with over 4,000 languages spoken across the continent.",
            "The largest country in Asia by land area is Russia, while the most populous country is China.",
            "The Maldives, an island nation in the Indian Ocean, is the lowest-lying country in the world.",
            "Asia is the birthplace of major religions such as Hinduism, Buddhism, Islam, and Confucianism.",
            "Tokyo, Japan, is the most populous metropolitan area in the world.")

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
            intent.putExtra("category", 4)
            startActivity(intent)
        }
    }
}