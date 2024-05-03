package com.example.geo_finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class AsQuestions : AppCompatActivity() {
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
            "Which Asian country is known as the \"Land of the Rising Sun\"?",
            listOf("Japan", "China", "Taiwan", "South Korea"), "Japan"
        )
        val question2 = Question(
            "In which country is the Great Wall located?",
            listOf("China", "Mongolia", "Russia", "India"), "China"
        )
        val question3 = Question(
            "Which river is considered the holiest in Hinduism and is a sacred river in India?",
            listOf("Ganges River", "Indus River", "Yellow River", "Salween River"), "Ganges River"
        )
        val question4 = Question(
            "What is the largest desert in Asia?",
            listOf("Gobi Desert", "Thar Desert", "Karakum Desert", "Thal Desert"), "Gobi Desert"
        )
        val question5 = Question(
            "What is the official language of Iran?",
            listOf("Persian", "Arabic", "Chinese", "Hebrew"), "Persian"
        )
        val question6 = Question(
            "In which country would you find the ancient city of Babylon?",
            listOf("Iraq", "Iran", "Kazakhstan", "Turkey"), "Iraq"
        )
        val question7 = Question(
            "What is the largest Muslim-majority country in the world?",
            listOf("Indonesia", "Saudi Arabia", "Iran", "Mongolia"), "Indonesia"
        )
        val question8 = Question(
            "Which river is considered the cradle of Chinese civilization and is often called the \"Mother River of China\"?",
            listOf("Yellow River", "Amur River", "Tarim River", "Yangtze River"), "Yellow River"
        )
        val question9 = Question(
            "Which Central Asian country is famous for its horse culture and nomadic traditions?",
            listOf("Mongolia", "Nepal", "Kuwait", "Uzbekistan"), "Mongolia"
        )
        val question10 = Question(
            "Which Asian country is the world's most populous, with over a billion people?",
            listOf("China", "Russia", "India", "Pakistan"), "China"
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