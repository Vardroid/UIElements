package com.example.uielements

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.Switch
import android.widget.TextView
import java.util.*

class SecondActivity : AppCompatActivity() {

    companion object{
        var age = ""
        var birthday = ""
        var phone = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val txtAge = findViewById<TextView>(R.id.ageTxt)
        val ageSeekBar = findViewById<SeekBar>(R.id.ageSeekBar)
        ageSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                txtAge.setText("${progress+16}").toString()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val pickDateBtn = findViewById<Button>(R.id.pickDateBtn)
        val bdayTxt = findViewById<TextView>(R.id.bdayTxt)
        pickDateBtn.setOnClickListener{
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                bdayTxt.setText(""+ (month+1) + " - " + dayOfMonth + " - " + year)
            }, year, month, day)
            dpd.show()
        }

        val phoneSwitch = findViewById<Switch>(R.id.phoneSwitch)
        val phoneTxt = findViewById<TextView>(R.id.phoneTxt)
        phoneSwitch?.setOnCheckedChangeListener{ _ , isChecked ->
            if(isChecked){
                phoneTxt.visibility = View.VISIBLE
            }else{
                phoneTxt.visibility = View.INVISIBLE
            }
        }

        findViewById<Button>(R.id.signUpBtn).setOnClickListener{signUp()}
    }
    private fun signUp(){
        age = findViewById<TextView>(R.id.ageTxt).text.toString()
        birthday = findViewById<TextView>(R.id.bdayTxt).text.toString()
        phone = findViewById<TextView>(R.id.phoneTxt).text.toString()
        val intent = Intent(this, ThirdActivity::class.java)
        startActivity(intent)
    }
}