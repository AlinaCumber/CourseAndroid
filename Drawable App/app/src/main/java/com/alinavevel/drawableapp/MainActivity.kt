package com.alinavevel.drawableapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.alinavevel.drawableapp.databinding.ActivityMainBinding
import com.alinavevel.drawableapp.databinding.DialogBrushSizeBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.drawView.setSizeForBrush(20.toFloat())

        binding.buttonBrush.setOnClickListener {
            showBrushDialog()
        }

        binding.btnBrown.setOnClickListener {
            binding.drawView.setColor("#8F442C")
        }
    }

    private fun showBrushDialog(){
        var brushDialog = Dialog(this)
        brushDialog.setTitle("Brush size: ")
        var bindingDialog : DialogBrushSizeBinding = DialogBrushSizeBinding.inflate(LayoutInflater.from(this))
        brushDialog.setContentView(bindingDialog.root)
        bindingDialog.small.setOnClickListener {
            binding.drawView.setSizeForBrush(10.toFloat())
            brushDialog.dismiss()
        }

        bindingDialog.medium.setOnClickListener {
            binding.drawView.setSizeForBrush(20.toFloat())
            brushDialog.dismiss()
        }

        bindingDialog.large.setOnClickListener {
            binding.drawView.setSizeForBrush(30.toFloat())
            brushDialog.dismiss()







        }

        brushDialog.show()


    }
}