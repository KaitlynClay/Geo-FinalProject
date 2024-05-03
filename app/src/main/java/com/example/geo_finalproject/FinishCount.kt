package com.example.geo_finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class FinishCount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish_count)

        val correctAnswersTxt: TextView = findViewById(R.id.compareTxt)
        val percentTxt: TextView = findViewById(R.id.percentTxt)
        val homeBtn: Button = findViewById(R.id.homeBtn)

        val correctAnswersCount = intent.getIntExtra("correct_answers_count", 0)
        val totalAnswers = intent.getIntExtra("total_answers", 0)

        val percentage = (correctAnswersCount.toDouble() / totalAnswers.toDouble()) * 100

        correctAnswersTxt.text = "Correct Answers: $correctAnswersCount"
        percentTxt.text = "Your final score: $percentage%"

        homeBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}