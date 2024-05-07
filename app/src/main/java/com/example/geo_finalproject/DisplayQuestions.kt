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

class DisplayQuestions : AppCompatActivity() {
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

        val category = intent.getIntExtra("category", 0)
        val questions = when (category) {
            1 -> listOf(
                Question(
                    "How many states make up the USA?",
            listOf("52", "50", "49", "51"), "50"
                ),
                Question(
                " What is the largest freshwater lake in North America?",
                listOf("Lake Erie", "Lake Huron", "Lake Michigan", "Lake Superior"), "Lake Superior"
                ),
                Question(
                "Which North American mammal has the longest migration?",
                listOf("Redwing Blackbird", "Canadian Geese", "Caribou", "Monarch Butterfly"), "Caribou"
                ),
                Question(
                "Which Canadian province has the largest French-speaking population outside of France?",
                listOf("Alberta", "Quebec", "Ontario", "Manitoba"), "Quebec"
                ),
                Question(
                " Which natural wonder in Arizona is one of the Seven Wonders of the Natural World?",
                listOf("Grand Canyon", "Monument Valley", "Lake Powell", "Horseshoe Bend"), "Grand Canyon"
                ),
                Question(
                "What is the most expensive city to live in North America?",
                listOf("Toronto", "Mexico City", "San Francisco", "New York City"), "San Francisco"
                ),
                Question(
                "What is the longest river in North America?",
                listOf("Rio Grande", "Yukon River", "Mississippi River", "Missouri River"), "Missouri River"
                ),
                Question(
                "What is the tallest mountain in North America?",
                listOf("Mt Logan", "Denali", "Mt Whitney", "Mt Rainier"), "Denali"
                ),
                Question(
                "What is the largest desert in North America?",
                listOf("Chihuahuan Desert", "Carson Desert", "Tule Desert", "Red Desert"), "Chihuahuan Desert"
                ),
                Question(
                "What is the highest waterfall in North America?",
                listOf("Fall Creek Falls", "Yosemite Falls", "Niagara Falls", "Multnomah Falls"), "Yosemite Falls"
                )
            )
            2 -> listOf(
                Question(
                    "How many countries are in South America?",
                listOf("12", "14", "10", "13"), "12"
                ),
                Question(
                "Which South American country is home to the worlds second-largest swimming pool?",
                listOf("Chile", "Brazil", "Peru", "Argentina"), "Chile"
                ),
                Question(
                "Which South American River is the longest?",
                listOf("Amazon River", "Purus River", "Jurua River", "Paraguay River"), "Amazon River"
                ),
                Question(
                "The world's largest salt flat in located in which South American Country?",
                listOf("Bolivia", "Brazil", "Venezuela", "Uruguay"), "Bolivia"
                ),
                Question(
                "Which city is the capital of Brazil?",
                listOf("Brasilia", "Belo Horizonte", "Fortaleza", "Salvador"), "Brasilia"
                ),
                Question(
                "Which South American country uses the US dollar as its official currency?",
                listOf("Ecuador", "Argentina", "Peru", "Suriname"), "Ecuador"
                ),
                Question(
                "Largest country in South America?",
                listOf("Brazil", "Argentina", "Columbia", "Paraguay"), "Brazil"
                ),
                Question(
                "What percentage of the world's alpaca population lives in Peru?",
                listOf("88%", "90%", "31.5%", "62%"), "88%"
                ),
                Question(
                "Which South American Nation is the world's largest producer of coffee?",
                listOf("Brazil", "Chile", "Columbia", "Argentina"), "Brazil"
                ),
                Question(
                "Most spoken language in South America?",
                listOf("Spanish", "English", "Portuguese", "Quechua"), "Spanish"
                )
            )
            3 -> listOf(
                Question(
                    "What is the longest river in Europe?",
                listOf("Volga River", "Danube River", "Rhine River", "Dnipro River"), "Volga River"
                ),
                Question(
                "Which European country is known as the \"Land of a Thousand Lakes\"?",
                listOf("Finland", "Norway", "Great Britain", "Russia"), "Finland"
                ),
                Question(
                "Which mountain range forms a natural border between France and Spain?",
                listOf("The Pyrenees", "Alps", "Ural Mountains", "Carpathian Mountains"), "The Pyrenees"
                ),
                Question(
                "Which European country is known for its windmills, tulip fields, and wooden shoes?",
                listOf("Netherlands", "Sweden", "Finland", "Croatia"), "Netherlands"
                ),
                Question(
                "What is the smallest country in Europe by land area?",
                listOf("Vatican City", "Monaco", "Malta", "San Marino"), "Vatican City"
                ),
                Question(
                "What is the highest mountain in Europe?",
                listOf("Mount Elbrus", "Mont Blanc", "Monte Rosa", "Dykh-Tau"), "Mount Elbrus"
                ),
                Question(
                "Which European country is famous for its beautiful castles, including Bran Castle, often associated with the Dracula legend?",
                listOf("Romania", "Croatia", "Turkey", "Italy"), "Romania"
                ),
                Question(
                "What is the name of the famous museum in Paris that is home to the Mona Lisa?",
                listOf("The Louvre", "Van Gogh Museum", "Rijksmuseum", "Uffizi gallery"), "The Louvre"
                ),
                Question(
                "Which European country is known as the \"Land of Fire and Ice\" due to its volcanic activity and glaciers?",
                listOf("Iceland", "Russia", "Sweden", "Norway"), "Iceland"
                ),
                Question(
                "What is the traditional Scottish musical instrument that features in many European folk tunes?",
                listOf("Bagpipes", "Celtic Harp", "Fiddle", "Tin Whistle"), "Bagpipes"
                )
            )
            4 -> listOf(
                Question(
                    "Which Asian country is known as the \"Land of the Rising Sun\"?",
                listOf("Japan", "China", "Taiwan", "South Korea"), "Japan"
                ),
                Question(
                "In which country is the Great Wall located?",
                listOf("China", "Mongolia", "Russia", "India"), "China"
                ),
                Question(
                "Which river is considered the holiest in Hinduism and is a sacred river in India?",
                listOf("Ganges River", "Indus River", "Yellow River", "Salween River"), "Ganges River"
                ),
                Question(
                "What is the largest desert in Asia?",
                listOf("Gobi Desert", "Thar Desert", "Karakum Desert", "Thal Desert"), "Gobi Desert"
                ),
                Question(
                "What is the official language of Iran?",
                listOf("Persian", "Arabic", "Chinese", "Hebrew"), "Persian"
                ),
                Question(
                "In which country would you find the ancient city of Babylon?",
                listOf("Iraq", "Iran", "Kazakhstan", "Turkey"), "Iraq"
                ),
                Question(
                "What is the largest Muslim-majority country in the world?",
                listOf("Indonesia", "Saudi Arabia", "Iran", "Mongolia"), "Indonesia"
                ),
                Question(
                "Which river is considered the cradle of Chinese civilization and is often called the \"Mother River of China\"?",
                listOf("Yellow River", "Amur River", "Tarim River", "Yangtze River"), "Yellow River"
                ),
                Question(
                "Which Central Asian country is famous for its horse culture and nomadic traditions?",
                listOf("Mongolia", "Nepal", "Kuwait", "Uzbekistan"), "Mongolia"
                ),
                Question(
                "Which Asian country is the world's most populous, with over a billion people?",
                listOf("China", "Russia", "India", "Pakistan"), "China"
                )
            )
            5 -> listOf(
                Question(
                    "Which river is the longest in Africa?",
                listOf("Nile River", "Congo River", "Chobe River", "Zambezi River"), "Nile River"
                ),
                Question(
                "What is the largest country in Africa by land area?",
                listOf("Algeria", "Ghana", "Senegal", "Niger"), "Algeria"
                ),
                Question(
                "What is the largest desert in Africa?",
                listOf("Sahara Desert", "Grand Bara", "Nubian Desert", "Kalahari Desert"), "Sahara Desert"
                ),
                Question(
                "What is the highest mountain in Africa?",
                listOf("Mount Kilimanjaro", "Mount Stanley", "Mount Kenya", "Mount Meru"), "Mount Kilimanjaro"
                ),
                Question(
                "What is the name of the largest lake in Africa?",
                listOf("Lake Victoria", "Lake Kivu", "Lake Albert", "Lake Malawi"), "Lake Victoria"
                ),
                Question(
                "In which African country would you find the Atlas Mountains?",
                listOf("Morocco", "Mali", "Uganda", "Algeria"), "Morocco"
                ),
                Question(
                "Which African river is known for its annual migration of wildebeest and zebras?",
                listOf("Mara River", "Grootrivier", "Lulonga", "Umfolozi River"), "Mara River"
                ),
                Question(
                "What is the official language of Angola?",
                listOf("Portuguese", "Spanish", "English", "French"), "Portuguese"
                ),
                Question(
                "Which African country is known as the \"Land of a Million Elephants\"?",
                listOf("Laos", "Angola", "Rwanda", "Cameroon"), "Laos"
                ),
                Question(
                "What is the largest national park in Africa, known for its wildlife including lions, elephants, and giraffes?",
                listOf("Chobe National Park", "Hwange National Park", "Kruger National Park", "Virunga National Park"), "Chobe National Park"
                )
            )
            6 -> listOf(
                Question(
                    "What is the highest peak in Antarctica?",
                listOf("Vinson Massif", "Mount Tyree", "Mount Gardner", "Mount Kirkpatrick"), "Vinson Massif"
                ),
                Question(
                "What is the coldest temperature ever recorded in Antarctica, and where was it recorded?",
                listOf("-128.6°F", "-153.7°F", "-112.0°F", "-120.3°F"), "-128.6°F"
                ),
                Question(
                " In what year did humans first set foot on Antarctica?",
                listOf("1820", "1910", "1812", "1842"), "1820"
                ),
                Question(
                "Which ocean surrounds Antarctica?",
                listOf("Southern Ocean", "Pacific Ocean", "Atlantic Ocean", "Indian Ocean"), "Southern Ocean"
                ),
                Question(
                "What is the largest ice shelf in Antarctica?",
                listOf("Ross Ice Shelf", "Filchner-Ronne Ice Shelf", "Quar Ice Shelf", "Vigrid Ice Shelfr"), "Ross Ice Shelf"
                ),
                Question(
                "What is the primary gas that makes up Antarctica's atmosphere?",
                listOf("Nitrogen", "Oxygen", "Hydrogen", "Methane"), "Nitrogen"
                ),
                Question(
                "What is the largest island in Antarctica?",
                listOf("Alexander Island", "Deception Island", "King George Island", "Ross Island"), "Alexander Island"
                ),
                Question(
                "What is the primary type of precipitation in Antarctica?",
                listOf("Snow", "Rain", "Ice", "Mist"), "Snow"
                ),
                Question(
                "What is the largest ice-covered (sub-glacial) freshwater lake in Antarctica?",
                listOf("Lake Vostok", "Lake Whillans", "Mercer Lake", "Lake Ellsworth"), "Lake Vostok"
                ),
                Question(
                "Which type of seal is commonly found in Antarctic waters?",
                listOf("Weddell seal", "Leopard seal", "Crabeater seal", "Elephant Seal"), "Weddell seal"
                )
            )
            7 -> listOf(
                Question(
                    "What is the largest country in Oceania by land area?",
                listOf("Australia", "New Zealand", "Fiji", "Tonga"), "Australia"
                ),
                Question(
                "What is the largest city in New Zealand?",
                listOf("Auckland", "Dunedin", "Wellington", "Queenstown"), "Auckland"
                ),
                Question(
                "In which country would you find the active volcano Mount Taranaki?",
                listOf("New Zealand", "New Caledonia", "Vanuatu", "Marshall Islands"), "New Zealand"
                ),
                Question(
                "Which Australian desert is the largest and occupies a significant part of the country's interior?",
                listOf(" Great Victoria Desert", "Pedirka Desert", "Tirari Desert", "Great Sandy Desert"), " Great Victoria Desert"
                ),
                Question(
                "Which Australian state is home to the famous landmark known as the Twelve Apostles?",
                listOf("Victoria", "Queensland", "Tasmania", "New South Wales"), "Victoria"
                ),
                Question(
                "What is the name of the largest lake in Australia?",
                listOf("Lake Eyre", "Lake Amadeus", "Dove Lake", "Blue Lake"), "Lake Eyre"
                ),
                Question(
                "Which island country in the Pacific Ocean is known as the \"Friendly Islands\"?",
                listOf("Tonga", "Solomon Islands", "Samoa", "Cook Islands"), "Tonga"
                ),
                Question(
                " In which Oceania country would you find the unique and endangered animal known as the kiwi?",
                listOf("New Zealand", "Australia", "Papa New Guinea", "Tokelau"), "New Zealand"
                ),
                Question(
                "In which country is the famous natural wonder known as the \"Waitomo Glowworm Caves\"?",
                listOf("New Zealand", "Tonga", "Samoa", "Guam"), "New Zealand"
                ),
                Question(
                "Which Australian state is renowned for its wine production, particularly in the regions of Barossa Valley and Clare Valley?",
                listOf("South Australia", "Victoria", "Western Australia", "Queensland"), "South Australia"
                )
            )
            else -> emptyList()
        }

        questionList.addAll(questions)
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