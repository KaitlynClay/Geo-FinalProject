package com.example.geo_finalproject

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class NAQuestions : AppCompatActivity() {
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
    private lateinit var correctFrame: FrameLayout
    private lateinit var wrongFrame: FrameLayout
    private lateinit var overlayView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        val question1 = Question(
            "How many states make up the USA?",
            listOf("52", "50", "49", "51"), "50"
        )
        val question2 = Question(
            " What is the largest freshwater lake in North America?",
            listOf("Lake Erie", "Lake Huron", "Lake Michigan", "Lake Superior"), "Lake Superior"
        )
        val question3 = Question(
            "Which North American mammal has the longest migration?",
            listOf("Redwing Blackbird", "Canadian Geese", "Caribou", "Monarch Butterfly"), "Caribou"
        )
        val question4 = Question(
            "Which Canadian province has the largest French-speaking population outside of France?",
            listOf("Alberta", "Quebec", "Ontario", "Manitoba"), "Quebec"
        )
        val question5 = Question(
            " Which natural wonder in Arizona is one of the Seven Wonders of the Natural World?",
            listOf("Grand Canyon", "Monument Valley", "Lake Powell", "Horseshoe Bend"), "Grand Canyon"
        )
        val question6 = Question(
            "What is the most expensive city to live in North America?",
            listOf("Toronto", "Mexico City", "San Francisco", "New York City"), "San Francisco"
        )
        val question7 = Question(
            "What is the longest river in North America?",
            listOf("Rio Grande", "Yukon River", "Mississippi River", "Missouri River"), "Missouri River"
        )
        val question8 = Question(
            "What is the tallest mountain in North America?",
            listOf("Mt Logan", "Denali", "Mt Whitney", "Mt Rainier"), "Denali"
        )
        val question9 = Question(
            "What is the largest desert in North America?",
            listOf("Chihuahuan Desert", "Carson Desert", "Tule Desert", "Red Desert"), "Chihuahuan Desert"
        )
        val question10 = Question(
            "What is the highest waterfall in North America?",
            listOf("Fall Creek Falls", "Yosemite Falls", "Niagara Falls", "Multnomah Falls"), "Yosemite Falls"
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
        correctFrame = findViewById(R.id.frameCorrect)
        wrongFrame = findViewById(R.id.frameWrong)
        overlayView = findViewById(R.id.overlayView)

        displayCurrentQuestion()

        val correctButton: Button = findViewById(R.id.nextBtnCorrect)
        val wrongButton: Button = findViewById(R.id.nextBtnWrong)

        correctButton.setOnClickListener {
            correctFrame.visibility = View.GONE
            overlayView.visibility = View.GONE
            if (currentQuestionIndex < shuffledQuestions.size) {
                displayCurrentQuestion()
            } else {
                moveToAnotherActivity()
            }
        }

        wrongButton.setOnClickListener {
            wrongFrame.visibility = View.GONE
            overlayView.visibility = View.GONE
            if (currentQuestionIndex < shuffledQuestions.size) {
                displayCurrentQuestion()
            } else {
                moveToAnotherActivity()
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (overlayView.visibility == View.VISIBLE) {
            true
        } else {
            super.onTouchEvent(event)
        }
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
                if (currentQuestionIndex <= shuffledQuestions.size) {
                    displayCurrentQuestion()
                }
            }
            optionBtn2.setOnClickListener {
                checkAnswer(optionBtn2.text.toString(), currentQuestion.correctAnswer)
                currentQuestionIndex++
                if (currentQuestionIndex <= shuffledQuestions.size) {
                    displayCurrentQuestion()
                }
            }
            optionBtn3.setOnClickListener {
                checkAnswer(optionBtn3.text.toString(), currentQuestion.correctAnswer)
                currentQuestionIndex++
                if (currentQuestionIndex <= shuffledQuestions.size) {
                    displayCurrentQuestion()
                }
            }
            optionBtn4.setOnClickListener {
                checkAnswer(optionBtn4.text.toString(), currentQuestion.correctAnswer)
                currentQuestionIndex++
                if (currentQuestionIndex <= shuffledQuestions.size) {
                    displayCurrentQuestion()
                }
            }
        }
    }


    private fun checkAnswer(selectedAnswer: String, correctAnswer: String) {
        if (selectedAnswer == correctAnswer) {
            correct++
            correctFrame.visibility = View.VISIBLE
            overlayView.visibility = View.VISIBLE

        } else {
            wrongFrame.visibility = View.VISIBLE
            overlayView.visibility = View.VISIBLE

            val corAnswerTxt = findViewById<TextView>(R.id.corAnswerTxt)
            corAnswerTxt.text = correctAnswer
        }
    }


    private fun moveToAnotherActivity() {
        overlayView.visibility = View.GONE
        val intent = Intent(this,FinishCount::class.java)
        intent.putExtra("correct_answers_count", correct)
        intent.putExtra("total_answers", total)
        startActivity(intent)
        finish()
    }

}