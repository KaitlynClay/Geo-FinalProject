package com.example.geo_finalproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class User_Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        val btnHome = findViewById<Button>(R.id.idBtnHome)
        val disName = findViewById<TextView>(R.id.idNameDisProf)
        val disUser = findViewById<TextView>(R.id.idUserDisProf)
        val disEmail = findViewById<TextView>(R.id.idEmailDisProf)
        val disPass = findViewById<TextView>(R.id.idPassDisProf)
        val disContin = findViewById<TextView>(R.id.idContinDisProf)
        val disNation = findViewById<TextView>(R.id.idNationDisProf)

        super.onResume()

        val sharedPref = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE)
        val savedName = sharedPref.getString("name", null)
        val savedUsername = sharedPref.getString("username", null)
        val savedEmail = sharedPref.getString("email", null)
        val savedPass = sharedPref.getString("password", null)
        val savedContin = sharedPref.getString("continent", null)
        val savedNation = sharedPref.getString("nation", null)
        disName.text = savedName
        disUser.text = savedUsername
        disEmail.text = savedEmail
        disPass.text = savedPass
        disContin.text = savedContin
        disNation.text = savedNation


        btnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}