package com.example.geo_finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Login : AppCompatActivity() {

    enum class LoginSuccess
        constructor(val intVal: Int) {
            name1(1),
            username(2),
            email(3),
            password(4),
            rePasword(5),
            continent(6),
            nation(7),
            success(0)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val nameTxt = findViewById<TextView>(R.id.idNameTxtEntry)
        val userTxt = findViewById<TextView>(R.id.idUsernameTxtEntry)
        val emailTxt = findViewById<TextView>(R.id.idEmailTxtEntry)
        val passTxt = findViewById<TextView>(R.id.idPasswordTxtEntry)
        val rePassTxt = findViewById<TextView>(R.id.idPasswordTxtReEntry)
        val continTxt = findViewById<TextView>(R.id.idContinentTxtEntry)
        val nationTxt = findViewById<TextView>(R.id.idNationTxtEntry)
        val btnLogin = findViewById<Button>(R.id.idLoginBtn)


        btnLogin.setOnClickListener {
            when (CheckLogin(nameTxt.text.toString(), userTxt.text.toString(), emailTxt.text.toString(), passTxt.text.toString(), rePassTxt.text.toString(), continTxt.text.toString(), nationTxt.text.toString())){
                LoginSuccess.name1 -> {
                    Toast.makeText(applicationContext, getString(R.string.errName), Toast.LENGTH_LONG).show()
                    nameTxt.requestFocus()
                }
                LoginSuccess.username -> {
                    Toast.makeText(applicationContext, getString(R.string.errUser), Toast.LENGTH_LONG).show()
                    userTxt.requestFocus()
                }
                LoginSuccess.email -> {
                    Toast.makeText(applicationContext, getString(R.string.errEmail), Toast.LENGTH_LONG).show()
                    emailTxt.requestFocus()
                }
                LoginSuccess.password -> {
                    Toast.makeText(applicationContext, getString(R.string.errPassword), Toast.LENGTH_LONG).show()
                    passTxt.requestFocus()
                }
                LoginSuccess.rePasword -> {
                    Toast.makeText(applicationContext, getString(R.string.errRePass), Toast.LENGTH_LONG).show()
                    rePassTxt.requestFocus()
                }
                LoginSuccess.continent -> {
                    Toast.makeText(applicationContext, getString(R.string.errContinent), Toast.LENGTH_LONG).show()
                    continTxt.requestFocus()
                }
                LoginSuccess.nation -> {
                    Toast.makeText(applicationContext, getString(R.string.errNation), Toast.LENGTH_LONG).show()
                    nationTxt.requestFocus()
                }
                else -> {
                    btnLogin.setOnClickListener {
                        val intent = Intent(this, MainActivity::class.java)
                        intent.putExtra("username", userTxt.text.toString())
                        startActivity(intent)
                    }
                }
            }
        }
    }
    fun CheckLogin(nameEntry: String, usernameEntry: String, emailEntry: String, passwordEntry: String, rePasswordEntry: String, continent: String, nation: String): Any {
        val deName = "Jade"
        val deUser = "JLennox"
        val deEmail = "jlennox9860@gmail.com"
        val dePass = "password"
        val validContinents = listOf<String>("North America", "South America", "Africa", "Asia", "Antarctica", "Australia", "Oceania", "Europe")

        return if (nameEntry != deName) {
            LoginSuccess.name1
        } else if (usernameEntry != deUser) {
            LoginSuccess.username
        } else if (emailEntry != deEmail) {
            LoginSuccess.email
        } else if (passwordEntry != dePass) {
            LoginSuccess.password
        } else if (rePasswordEntry != passwordEntry) {
            LoginSuccess.rePasword
        } else if (continent.isEmpty() || !validContinents.contains(continent)) {
            LoginSuccess.continent
        } else if (nation.isEmpty()) {
            LoginSuccess.nation
        } else {
            LoginSuccess.success
        }
    }
}
