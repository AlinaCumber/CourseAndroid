package com.alinavevel.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.alinavevel.quizapp.databinding.ActivityMainBinding
import com.alinavevel.quizapp.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {
    lateinit var binding: ActivityQuizBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Toast.makeText(this, "You have ${Constans.getQuestions().size}", Toast.LENGTH_LONG).show()
    }
}