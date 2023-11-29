package com.example.geo_finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class AnQuestions : AppCompatActivity() {
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
        setContentView(R.layout.activity_naquestions)

        val question1 = Question(
            "How many countries are in South America?",
            listOf("12", "14", "10", "13"), "12"
        )
        val question2 = Question(
            "Which South American country is home to the worlds second-largest swimming pool?",
            listOf("Chile", "Brazil", "Peru", "Argentina"), "Chile"
        )
        val question3 = Question(
            "Which South American River is the longest?",
            listOf("Amazon River", "Purus River", "Jurua River", "Paraguay River"), "Amazon River"
        )
        val question4 = Question(
            "The world's largest salt flat in located in which South American Country?",
            listOf("Bolivia", "Brazil", "Venezuela", "Uruguay"), "Bolivia"
        )
        val question5 = Question(
            "Which city is the capital of Brazil?",
            listOf("Brasilia", "Belo Horizonte", "Fortaleza", "Salvador"), "Brasilia"
        )
        val question6 = Question(
            "Which South American country uses the US dollar as its official currency?",
            listOf("Ecuador", "Argentina", "Peru", "Suriname"), "Ecuador"
        )
        val question7 = Question(
            "Largest country in South America?",
            listOf("Brazil", "Argentina", "Columbia", "Paraguay"), "Brazil"
        )
        val question8 = Question(
            "What percentage of the world's alpaca population lives in Peru?",
            listOf("88%", "90%", "31.5%", "62%"), "88%"
        )
        val question9 = Question(
            "Which South American Nation is the world's largest producer of coffee?",
            listOf("Brazil", "Chile", "Columbia", "Argentina"), "Brazil"
        )
        val question10 = Question(
            "Most spoken language in South America?",
            listOf("Spanish", "English", "Portuguese", "Quechua"), "Spanish"
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
        if (selectedAnswer == correctAnswer) {
            Toast.makeText(this,getString(R.string.correctMes), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this,"Incorrect. The correct answer is $correctAnswer", Toast.LENGTH_SHORT).show()
        }
    }

    private fun moveToAnotherActivity() {
        val intent = Intent(this,Antarctica::class.java)
        startActivity(intent)
        finish()
    }

}


