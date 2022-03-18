package com.alinavevel.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    var tvResult : TextView? = null;
    var lastDigit : Boolean = false;
    var buttonEquals : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tvresult)
        buttonEquals = findViewById(R.id.equal)

        buttonEquals?.setOnClickListener {
            onEquals()
        }

    }

    fun onDigit(view: View) {
        tvResult?.append((view as Button).text)
        lastDigit = true;
    }

    fun onClear(view: View){
        tvResult?.text = ""
    }

    fun onDecimlPoint(view: View){
        if(!(tvResult?.text)!!.contains(".") && !(tvResult?.text)?.equals("")!!){
            tvResult?.append(".")
            lastDigit = false;
        }

    }

    fun onEquals(){
        val ex = ExpressionBuilder(tvResult?.text.toString()).build()
        val result = ex.evaluate()
        tvResult?.text = result.toString()
    }

    fun onOperator(view: View){
        if(lastDigit && !isOperatorAdding(tvResult?.text.toString())){
            tvResult?.append((view as Button).text)
            lastDigit = false
        }
        else if((tvResult?.text)?.equals("")!! && !isOperatorAdding(tvResult?.text.toString())){
            tvResult?.append((view as Button).text)
            lastDigit = false
        }
    }

    fun isOperatorAdding(value: String) : Boolean{
        return if(value.startsWith("-")){
            false
        }else{
            value.contains("-") || value.contains("/") || value.contains("*")
                    || value.contains("+")
        }
    }
}