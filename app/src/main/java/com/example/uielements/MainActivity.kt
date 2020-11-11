package com.example.uielements

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    companion object{
        var firstName = ""
        var lastName = ""
        var email = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.nextBtn).setOnClickListener{nextAct()}
    }
    private fun nextAct(){
        firstName = findViewById<TextView>(R.id.firstNameTxt).text.toString()
        lastName = findViewById<TextView>(R.id.lastNameTxt).text.toString()
        email = findViewById<TextView>(R.id.emailTxt).text.toString()
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
}