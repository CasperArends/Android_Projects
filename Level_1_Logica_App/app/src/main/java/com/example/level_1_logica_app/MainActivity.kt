package com.example.level_1_logica_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_Enter.setOnClickListener {
            onConfirmClick()
        }
    }

    fun onConfirmClick(){

        var answer1 = et_1.text.toString()
        var answer2 = et_2.text.toString()
        var answer3 = et_3.text.toString()
        var answer4 = et_4.text.toString()

        if (answer1 == "T" && answer2 == "F" && answer3 == "F" && answer4 == "F"){
            onAnswerCorrect()
        }else{
            onAnswerincorrect()
        }

    }

    private fun onAnswerCorrect(){
        Toast.makeText(this, getString(R.string.correct),Toast.LENGTH_LONG).show()
    }

    private fun onAnswerincorrect(){
        Toast.makeText(this, getString(R.string.incorrect),Toast.LENGTH_LONG).show()

    }
}
