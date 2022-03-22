package com.alinavevel.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.alinavevel.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnStart.setOnClickListener {

            if(binding.inputText.text!!.isNotEmpty()){
                val intent = Intent(this, QuizActivity::class.java)
                intent.putExtra(Constans.USER_NAME, binding.inputText.text.toString())
                startActivity(intent)
                finish()
            }

        }
    }
}