package com.example.geo_finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class AfQuestions : AppCompatActivity() {
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
            "Which river is the longest in Africa?",
            listOf("Nile River", "Congo River", "Chobe River", "Zambezi River"), "Nile River"
        )
        val question2 = Question(
            "What is the largest country in Africa by land area?",
            listOf("Algeria", "Ghana", "Senegal", "Niger"), "Algeria"
        )
        val question3 = Question(
            "What is the largest desert in Africa?",
            listOf("Sahara Desert", "Grand Bara", "Nubian Desert", "Kalahari Desert"), "Sahara Desert"
        )
        val question4 = Question(
            "What is the highest mountain in Africa?",
            listOf("Mount Kilimanjaro", "Mount Stanley", "Mount Kenya", "Mount Meru"), "Mount Kilimanjaro"
        )
        val question5 = Question(
            "What is the name of the largest lake in Africa?",
            listOf("Lake Victoria", "Lake Kivu", "Lake Albert", "Lake Malawi"), "Lake Victoria"
        )
        val question6 = Question(
            "In which African country would you find the Atlas Mountains?",
            listOf("Morocco", "Mali", "Uganda", "Algeria"), "Morocco"
        )
        val question7 = Question(
            "Which African river is known for its annual migration of wildebeest and zebras?",
            listOf("Mara River", "Grootrivier", "Lulonga", "Umfolozi River"), "Mara River"
        )
        val question8 = Question(
            "What is the official language of Angola?",
            listOf("Portuguese", "Spanish", "English", "French"), "Portuguese"
        )
        val question9 = Question(
            "Which African country is known as the \"Land of a Million Elephants\"?",
            listOf("Laos", "Angola", "Rwanda", "Cameroon"), "Laos"
        )
        val question10 = Question(
            "What is the largest national park in Africa, known for its wildlife including lions, elephants, and giraffes?",
            listOf("Chobe National Park", "Hwange National Park", "Kruger National Park", "Virunga National Park"), "Chobe National Park"
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


