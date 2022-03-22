package com.alinavevel.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alinavevel.quizapp.databinding.ActivityMainBinding
import com.alinavevel.quizapp.databinding.ActivityResultBinding

class Result : AppCompatActivity() {
    private lateinit var binding : ActivityResultBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(Constans.USER_NAME)
        val correctAnswer = intent.getIntExtra(Constans.CORRECT_ANSWER, 0)
        val count = intent.getIntExtra(Constans.QUESTION_COUNT, 0)

        binding.name.text = name
        binding.userResult.text = "Your result is $correctAnswer of $count"

        binding.btnFinish.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}