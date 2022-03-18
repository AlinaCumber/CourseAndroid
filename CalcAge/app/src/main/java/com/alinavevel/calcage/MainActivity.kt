package com.alinavevel.calcage

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

import android.widget.TextView

import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    var textBirht : TextView? = null
    var ageInMin : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var buttonCalc = findViewById<Button>(R.id.button)
        textBirht  = findViewById(R.id.selectedDate)
        ageInMin = findViewById(R.id.ageInMinutes)

        buttonCalc.setOnClickListener {
            clickDataicker()
        }


    }

    fun clickDataicker(){
        val myCalender =  Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(
            this, DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->

                textBirht?.text = "$dayOfMonth/${month+1}/$year"

                val date = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val dateFin = date.parse(textBirht?.text.toString())
                val currentDate = (date.parse(date.format(System.currentTimeMillis()))).time / 60000
                val dateInMin = dateFin.time / 60000
                val dateFinal = currentDate - dateInMin
                ageInMin?.text = dateFinal.toString()
            },
            year,
            month,
            day
        )

        dpd.datePicker.maxDate = System.currentTimeMillis()
        dpd.show()
    }




}