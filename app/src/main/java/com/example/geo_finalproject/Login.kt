package com.example.geo_finalproject

import android.content.Context
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

        nameTxt.requestFocus()


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
                        val sharedPref = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE)
                        val sharedPrefEditor = sharedPref.edit()
                        sharedPrefEditor.putString("name", nameTxt.text.toString())
                        sharedPrefEditor.putString("username", userTxt.text.toString())
                        sharedPrefEditor.putString("email", emailTxt.text.toString())
                        sharedPrefEditor.putString("password", passTxt.text.toString())
                        sharedPrefEditor.putString("continent", continTxt.text.toString())
                        sharedPrefEditor.putString("nation", nationTxt.text.toString())
                        sharedPrefEditor.apply()
                        startActivity(intent)

                    }
                }
            }
        }
    }
    fun CheckLogin(nameEntry: String, usernameEntry: String, emailEntry: String, passwordEntry: String, rePasswordEntry: String, continent: String, nation: String): Any {
        val validContinents = listOf<String>("North America", "South America", "Africa", "Asia", "Antarctica", "Australia", "Oceania", "Europe",
            "north america", "south america", "africa", "asia", "antarctica", "australia", "oceania", "europe" ,
            "north America", "south America", "North america", "South america")

        return if (nameEntry.isEmpty()) {
            LoginSuccess.name1
        } else if (usernameEntry.isEmpty()) {
            LoginSuccess.username
        } else if (emailEntry.isEmpty()) {
            LoginSuccess.email
        } else if (passwordEntry.isEmpty()) {
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
