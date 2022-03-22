package com.alinavevel.quizapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.alinavevel.quizapp.databinding.ActivityMainBinding
import com.alinavevel.quizapp.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {
    lateinit var binding: ActivityQuizBinding
    private var listOfQuestion = ArrayList<Question>()
    private var currentPosition: Int = 1
    private var selectedOption: Int = 0
    private var correctAnswer : Int = 0
    private var username : String? = null



    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        username = intent.getStringExtra(Constans.USER_NAME)

        listOfQuestion = Constans.getQuestions()

        setQuestion()

        binding.optionOne.setOnClickListener {
            selectedOption(binding.optionOne, 1)
        }

        binding.optionTwo.setOnClickListener {
            selectedOption(binding.optionTwo, 2)
        }

        binding.optionThree.setOnClickListener {
            selectedOption(binding.optionThree, 3)
        }

        binding.optionFour.setOnClickListener {
            selectedOption(binding.optionFour, 4)
        }

        binding.btnSubmint.setOnClickListener {
            if (selectedOption == 0) {

                currentPosition++

                if (currentPosition <= listOfQuestion.size) {

                    setQuestion()
                } else {

                    val intent = Intent(this, Result::class.java)

                    intent.putExtra(Constans.USER_NAME, username)
                    intent.putExtra(Constans.CORRECT_ANSWER, correctAnswer)
                    intent.putExtra(Constans.QUESTION_COUNT, listOfQuestion.size)

                    startActivity(intent)
                    finish()
                }
            }
            else {
                val question = listOfQuestion[currentPosition - 1]

                // This is to check if the answer is wrong
                if (question.correctAnswer != selectedOption) {
                    answerView(selectedOption, R.drawable.incurrect_text_view)


                }
                else{
                    correctAnswer++
                }


                answerView(question.correctAnswer, R.drawable.correct_text_view)

                if (currentPosition == listOfQuestion.size) {
                    binding.btnSubmint.text = "FINISH"

                } else {
                    binding.btnSubmint.text = "GO TO NEXT QUESTION"
                }

                selectedOption = 0

            }
        }

    }



    @SuppressLint("ResourceAsColor")
    private fun selectedOption(tv: TextView, mselectedOption : Int){

        defoultOption()
        selectedOption = mselectedOption
        tv.setTextColor(R.color.purple_700)
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_bg
        )
    }

    @SuppressLint("ResourceAsColor")
    private fun defoultOption(){
        var options = ArrayList<TextView>()

        options.add(0, binding.optionOne)
        options.add(1, binding.optionTwo)
        options.add(2, binding.optionThree)
        options.add(3, binding.optionFour)

        for(option in options){
            option.setTextColor(R.color.teal_700)
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.bg_text_view
            )
        }
    }

    private fun answerView(id: Int, color :Int){
        when(id){
            1 -> { binding.optionOne.background = ContextCompat.getDrawable(this, color)
            }
            2 -> { binding.optionTwo.background = ContextCompat.getDrawable(this, color)
            }
            3 -> { binding.optionThree.background = ContextCompat.getDrawable(this, color)
            }
            4 -> { binding.optionFour.background = ContextCompat.getDrawable(this, color)
            }
        }
    }

    private fun setQuestion() {

        val question: Question = listOfQuestion[currentPosition - 1]

        defoultOption()

        if (currentPosition == listOfQuestion.size) {
            binding.btnSubmint.text = "FINISH"
        } else {
            binding.btnSubmint.text = "SUBMIT"
        }

        binding.progress.progress = currentPosition
        binding.tvProgress.text = "$currentPosition / ${binding.progress.max}"
        binding.questionText.text = question.question
        binding.optionOne.text = question.ansewer1
        binding.optionTwo.text = question.ansewer2
        binding.optionThree.text = question.ansewer3
        binding.optionFour.text = question.ansewer4
        binding.fotoFlag.setImageResource(question.imagen)


    }
}