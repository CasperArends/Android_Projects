package com.example.level_1_higher_lower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_higher_lower.*

class MainActivity : AppCompatActivity() {

    private var currentThrow: Int = 1
    private var lastThrow: Int = 1



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_lower)
        initViews()

        btnLower.setOnClickListener{
            onLowerClick()
        }

        btnEqual.setOnClickListener {
            onEqualClick()
        }

        btnHigher.setOnClickListener {
            onHigherClick()
        }


    }

    //Set the initial UI state of the app
    private fun initViews(){

        updateUI()
    }


    private fun updateUI(){
        tvLastThrow.text = getString(R.string.last_throw, lastThrow)

        when (currentThrow) {
            1 -> imageViewDice.setImageResource(R.drawable.dice1)
            2 -> imageViewDice.setImageResource(R.drawable.dice2)
            3 -> imageViewDice.setImageResource(R.drawable.dice3)
            4 -> imageViewDice.setImageResource(R.drawable.dice4)
            5 -> imageViewDice.setImageResource(R.drawable.dice5)
            6 -> imageViewDice.setImageResource(R.drawable.dice6)
        }
    }

    private fun rollDice(){
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    /**
     * Displays a correct toast message
     * */
    private fun onAnswerCorrect(){
        /**
         *val text = "Correct!"
         *val duration = Toast.LENGTH_SHORT
         *val toast = Toast.makeText(applicationContext, text, duration)
         *toast.show()
         */
        Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_SHORT).show()
    }



    /**
     * Displays a incorrect toast message
     * */
    private fun onAnswerIncorrrect(){
        Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_SHORT).show()
    }

    /**
     * calls [rollDice] and checks if the answer is lower than the current dice roll
     * */
    private fun onLowerClick(){
        rollDice()
        if ( currentThrow < lastThrow){
            onAnswerCorrect()
        }else{

            onAnswerIncorrrect()
        }
    }


    /**
     * calls [rollDice] and checks if the answer is equal to the current dice roll
     * */
    private fun onEqualClick(){
        rollDice()
        if ( currentThrow == lastThrow){
            onAnswerCorrect()
        }else{
            onAnswerIncorrrect()

        }

    }


    /**
     * calls [rollDice] and checks if the answer is higher than the current dice roll
     * */
    private fun onHigherClick(){
        rollDice()
        if ( currentThrow > lastThrow){
            onAnswerCorrect()
        }else{
            onAnswerIncorrrect()
        }

    }

}
