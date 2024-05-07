package com.example.geo_finalproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.Random

class NorthAmerica : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_northamerica)

        val ranFactTxt = findViewById<TextView>(R.id.ranFactTxt)
        val facts = listOf("The world's longest undefended border is between Canada and the United States.",
            "North America is home to the world's third-largest river, the Mississippi-Missouri River System.",
            "The Great Lakes, shared by the United States and Canada, contain about 20% of the world's fresh surface water.",
            "The highest peak in North America is Denali (formerly known as Mount McKinley) in Alaska, with an elevation of 6,190 meters (20,310 feet).",
            "North America has the largest economy in the world, largely due to the United States' economic dominance.",
            "The Panama Canal, connecting the Atlantic and Pacific Oceans, is a vital shipping route in North America.",
            "Yellowstone National Park in the United States is the first national park in the world.",
            "The Appalachian Mountains, extending from Canada to Alabama in the United States, are one of the oldest mountain ranges on Earth.",
            "North America is home to diverse indigenous cultures, including the Inuit of the Arctic, Native American tribes, and various First Nations in Canada.",
            "North America is home to diverse indigenous cultures, including the Inuit of the Arctic, Native American tribes, and various First Nations in Canada.")

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
            intent.putExtra("category", 1)
            startActivity(intent)
        }
    }
}