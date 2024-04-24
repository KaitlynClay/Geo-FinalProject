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
    private var correct = 0
    private var total = 0
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
            "What is the highest peak in Antarctica?",
            listOf("Vinson Massif", "Mount Tyree", "Mount Gardner", "Mount Kirkpatrick"), "Vinson Massif"
        )
        val question2 = Question(
            "What is the coldest temperature ever recorded in Antarctica, and where was it recorded?",
            listOf("-128.6°F", "-153.7°F", "-112.0°F", "-120.3°F"), "-128.6°F"
        )
        val question3 = Question(
            " In what year did humans first set foot on Antarctica?",
            listOf("1820", "1910", "1812", "1842"), "1820"
        )
        val question4 = Question(
            "Which ocean surrounds Antarctica?",
            listOf("Southern Ocean", "Pacific Ocean", "Atlantic Ocean", "Indian Ocean"), "Southern Ocean"
        )
        val question5 = Question(
            "What is the largest ice shelf in Antarctica?",
            listOf("Ross Ice Shelf", "Filchner-Ronne Ice Shelf", "Quar Ice Shelf", "Vigrid Ice Shelfr"), "Ross Ice Shelf"
        )
        val question6 = Question(
            "What is the primary gas that makes up Antarctica's atmosphere?",
            listOf("Nitrogen", "Oxygen", "Hydrogen", "Methane"), "Nitrogen"
        )
        val question7 = Question(
            "What is the largest island in Antarctica?",
            listOf("Alexander Island", "Deception Island", "King George Island", "Ross Island"), "Alexander Island"
        )
        val question8 = Question(
            "What is the primary type of precipitation in Antarctica?",
            listOf("Snow", "Rain", "Ice", "Mist"), "Snow"
        )
        val question9 = Question(
            "What is the largest ice-covered (sub-glacial) freshwater lake in Antarctica?",
            listOf("Lake Vostok", "Lake Whillans", "Mercer Lake", "Lake Ellsworth"), "Lake Vostok"
        )
        val question10 = Question(
            "Which type of seal is commonly found in Antarctic waters?",
            listOf("Weddell seal", "Leopard seal", "Crabeater seal", "Elephant Seal"), "Weddell seal"
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
        total = shuffledQuestions.size

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
            moveToAnotherActivity()
        }
    }

    private fun checkAnswer(selectedAnswer: String, correctAnswer: String) {
        if (selectedAnswer == correctAnswer) {
            correct++
            val correctIntent = Intent(this, CorrectActivity::class.java)
            startActivity(correctIntent)
        } else {
            val wrongIntent = Intent(this, WrongActivity::class.java)
            wrongIntent.putExtra("correct_answer", correctAnswer)
            startActivity(wrongIntent)
        }
    }

    private fun moveToAnotherActivity() {
        val intent = Intent(this,FinishCount::class.java)
        intent.putExtra("correct_answers_count", correct)
        intent.putExtra("total_answers", total)
        startActivity(intent)
        finish()
    }

}


