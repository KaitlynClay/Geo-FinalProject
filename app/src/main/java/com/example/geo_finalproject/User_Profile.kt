package com.example.geo_finalproject

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

        val name = intent.getStringExtra("name")
        disName.text = name
        val user = intent.getStringExtra("username")
        disUser.text = user
        val email = intent.getStringExtra("email")
        disEmail.text = email
        val pass = intent.getStringExtra("password")
        disPass.text = pass
        val contin = intent.getStringExtra("continent")
        disContin.text = contin
        val nation = intent.getStringExtra("nation")
        disNation.text = nation


        btnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}