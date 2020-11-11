package com.example.uielements

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.toDrawable

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        findViewById<TextView>(R.id.nameTxt).setText(MainActivity.firstName+" "+MainActivity.lastName)
        findViewById<TextView>(R.id.emailAddTxt).setText("Email: "+MainActivity.email)
        findViewById<TextView>(R.id.ageFTxt).setText("Age: "+SecondActivity.age)
        findViewById<TextView>(R.id.birthdayFTxt).setText("Birthday: "+SecondActivity.birthday)
        findViewById<TextView>(R.id.phoneFTxt).setText("Phone: "+SecondActivity.phone)

        val randomNumber = (0..4).random()
        val photos= arrayOf(R.drawable.ava1, R.drawable.ava2, R.drawable.ava3, R.drawable.ava4)
        val image = findViewById<ImageView>(R.id.image).setImageResource(photos[randomNumber])
    }
}