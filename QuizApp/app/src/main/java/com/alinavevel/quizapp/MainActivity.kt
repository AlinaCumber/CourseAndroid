package com.alinavevel.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart: Button = findViewById(R.id.btn_start)
        val text: EditText = findViewById(R.id.inputText)

        btnStart.setOnClickListener {

            if(text.text.isNotEmpty()){
                val intent = Intent(this, QuizActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
    }
}