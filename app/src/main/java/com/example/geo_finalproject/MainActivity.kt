package com.example.geo_finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val profileBtn = findViewById<Button>(R.id.idUserBtn)
        profileBtn.setOnClickListener {
            val intent = Intent(this, User_Profile::class.java)
            startActivity(intent)
        }
        val user = intent.getStringExtra("username")
        val user2L = user?.take(2)
        profileBtn.text = user2L

        val btnNA = findViewById<Button>(R.id.idNorthAmerica)
        btnNA.setOnClickListener {
            val intent = Intent(this, NorthAmerica::class.java)
            startActivity(intent)
        }
        val btnSA = findViewById<Button>(R.id.idSouthAmerica)
        btnSA.setOnClickListener {
            val intent = Intent(this,SouthAmerica::class.java)
            startActivity(intent)
        }
        val btnEur = findViewById<Button>(R.id.idEurope)
        btnEur.setOnClickListener {
            val intent = Intent(this,Europe::class.java)
            startActivity(intent)
        }
        val btnAi = findViewById<Button>(R.id.idAsia)
        btnAi.setOnClickListener {
            val intent = Intent(this,Asia::class.java)
            startActivity(intent)
        }
        val btnAusnOc = findViewById<Button>(R.id.idAusnOcean)
        btnAusnOc.setOnClickListener {
            val intent = Intent(this,AustralianOceania::class.java)
            startActivity(intent)
        }
        val btnAnt = findViewById<Button>(R.id.idAntarctica)
        btnAnt.setOnClickListener {
            val intent = Intent(this,Antarctica::class.java)
            startActivity(intent)
        }
        val btnAf = findViewById<Button>(R.id.idAfrica)
        btnAf.setOnClickListener {
            val intent = Intent(this,Africa::class.java)
            startActivity(intent)
        }
    }
}