package com.example.geo_finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class AnOQuestions : AppCompatActivity() {
    private val questionList = mutableListOf<Question>()
    private var shuffledQuestions: List<Question> = emptyList()
    private var currentQuestionIndex = 0
    private lateinit var optionsLayout: LinearLayout
    private lateinit var questionTxtView: TextView
    private lateinit var optionBtn1: Button
    private lateinit var optionBtn2: Button
    private lateinit var optionBtn3: Button
    private lateinit var optionBtn4: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        val question1 = Question(
            "What is the largest country in Oceania by land area?",
            listOf("Australia", "New Zealand", "Fiji", "Tonga"), "Australia"
        )
        val question2 = Question(
            "What is the largest city in New Zealand?",
            listOf("Auckland", "Dunedin", "Wellington", "Queenstown"), "Auckland"
        )
        val question3 = Question(
            "In which country would you find the active volcano Mount Taranaki?",
            listOf("New Zealand", "New Caledonia", "Vanuatu", "Marshall Islands"), "New Zealand"
        )
        val question4 = Question(
            "Which Australian desert is the largest and occupies a significant part of the country's interior?",
            listOf(" Great Victoria Desert", "Pedirka Desert", "Tirari Desert", "Great Sandy Desert"), " Great Victoria Desert"
        )
        val question5 = Question(
            "Which Australian state is home to the famous landmark known as the Twelve Apostles?",
            listOf("Victoria", "Queensland", "Tasmania", "New South Wales"), "Victoria"
        )
        val question6 = Question(
            "What is the name of the largest lake in Australia?",
            listOf("Lake Eyre", "Lake Amadeus", "Dove Lake", "Blue Lake"), "Lake Eyre"
        )
        val question7 = Question(
            "Which island country in the Pacific Ocean is known as the \"Friendly Islands\"?",
            listOf("Tonga", "Solomon Islands", "Samoa", "Cook Islands"), "Tonga"
        )
        val question8 = Question(
            " In which Oceania country would you find the unique and endangered animal known as the kiwi?",
            listOf("New Zealand", "Australia", "Papa New Guinea", "Tokelau"), "New Zealand"
        )
        val question9 = Question(
            "In which country is the famous natural wonder known as the \"Waitomo Glowworm Caves\"?",
            listOf("New Zealand", "Tonga", "Samoa", "Guam"), "New Zealand"
        )
        val question10 = Question(
            "Which Australian state is renowned for its wine production, particularly in the regions of Barossa Valley and Clare Valley?",
            listOf("South Australia", "Victoria", "Western Australia", "Queensland"), "South Australia"
        )

        questionList.add(question1)
        questionList.add(question2)
        questionList.add(question3)
        questionList.add(question4)
        questionList.add(question5)
        questionList.add(question6)
        questionList.add(question7)
        questionList.add(question8)
        questionList.add(question9)
        questionList.add(question10)

        shuffledQuestions = questionList.shuffled()

        questionTxtView = findViewById(R.id.idQuestionTxt)
        optionBtn1 = findViewById(R.id.idAnswerOne)
        optionBtn2 = findViewById(R.id.idAnswerTwo)
        optionBtn3 = findViewById(R.id.idAnswerThree)
        optionBtn4 = findViewById(R.id.idAnswerFour)

        displayCurrentQuestion()
    }

    private fun displayCurrentQuestion() {
        val progressTxt: TextView = findViewById(R.id.curTotalTxt)
        val currentQuestionNumber = currentQuestionIndex + 1
        progressTxt.text = "$currentQuestionNumber / ${shuffledQuestions.size}"

        if (currentQuestionIndex < shuffledQuestions.size) {
            val currentQuestion = shuffledQuestions[currentQuestionIndex]
            questionTxtView.text = currentQuestion.questionTxt
            val shuffledOptions = currentQuestion.options.shuffled()

            optionBtn1.text = shuffledOptions[0]
            optionBtn2.text = shuffledOptions[1]
            optionBtn3.text = shuffledOptions[2]
            optionBtn4.text = shuffledOptions[3]

            optionBtn1.setOnClickListener {
                checkAnswer(optionBtn1.text.toString(), currentQuestion.correctAnswer)
                currentQuestionIndex++
                displayCurrentQuestion()
            }
            optionBtn2.setOnClickListener {
                checkAnswer(optionBtn2.text.toString(), currentQuestion.correctAnswer)
                currentQuestionIndex++
                displayCurrentQuestion()
            }
            optionBtn3.setOnClickListener {
                checkAnswer(optionBtn3.text.toString(), currentQuestion.correctAnswer)
                currentQuestionIndex++
                displayCurrentQuestion()
            }
            optionBtn4.setOnClickListener {
                checkAnswer(optionBtn4.text.toString(), currentQuestion.correctAnswer)
                currentQuestionIndex++
                displayCurrentQuestion()
            }
        } else {
            Toast.makeText(this,getString(R.string.completed), Toast.LENGTH_SHORT).show()
            moveToAnotherActivity()
        }
    }

    private fun checkAnswer(selectedAnswer: String, correctAnswer: String) {
        var correct = 0
        if (selectedAnswer == correctAnswer) {
            correct += 1
            val correctIntent = Intent(this, CorrectActivity::class.java)
            startActivity(correctIntent)
        } else {
            val wrongIntent = Intent(this, WrongActivity::class.java)
            wrongIntent.putExtra("correct_answer", correctAnswer)
            startActivity(wrongIntent)
        }
    }

    private fun moveToAnotherActivity() {
        val intent = Intent(this,AustralianOceania::class.java)
        startActivity(intent)
        finish()
    }

}


