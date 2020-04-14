package com.example.rockpaperscissors

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var rpsRepository : RockPaperScissorRepository

    private var computerChoice: Int = 0
    private var playerChoice: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setSupportActionBar(toolbar)
        supportActionBar?.title = "Rock, Paper, Scissors Kotlin"

        //Set the rpsRepo and onclickListeners
        rpsRepository = RockPaperScissorRepository(this)
        initViews()

    }

    private fun initViews(){
        btnPaper.setOnClickListener{ playPaper() }
        btnRock.setOnClickListener{ playRock() }
        btnScissors.setOnClickListener{ playScissors() }
    }


    private fun addGamesToDatabase(){
        CoroutineScope(Dispatchers.Main).launch {
            val rps = RockPaperScissor(
                winner = tvResult.text.toString(),
                computerChoice = computerChoice,
                playerChoice = playerChoice,
                date = Date().toString()
            )
            withContext(Dispatchers.IO){
                rpsRepository.insertGame(rps)
            }
        }
    }

    //Set the image chosen to the choice of the computer and player
    private fun playPaper(){
        ivPlayer.setImageResource(R.drawable.paper)
        playerChoice = 1
        generateComputerMove()
        playGame(playerChoice, computerChoice)
    }
    private fun playRock(){
        ivPlayer.setImageResource(R.drawable.rock)
        playerChoice = 2
        generateComputerMove()
        playGame(playerChoice, computerChoice)
    }
    private fun playScissors(){
        ivPlayer.setImageResource(R.drawable.scissors)
        playerChoice = 3
        generateComputerMove()
        playGame(playerChoice, computerChoice)
    }

    //Generate a random choice for the computer
    private fun generateComputerMove(){
        computerChoice = (1..3).random()
        when(computerChoice){
            1 -> ivComputer.setImageResource(R.drawable.paper)
            2 -> ivComputer.setImageResource(R.drawable.rock)
            3 -> ivComputer.setImageResource(R.drawable.scissors)
        }
    }

    //Set the condtions of winning/losing/draw match
    private fun playGame(playerMove: Int, computerMove: Int){
        if (computerMove == playerMove){
            tvResult.text = "Draw!"
        }
        else if (computerMove == 1 && playerMove == 2){
            tvResult.text = "Computer Wins!"
        }
        else if (computerMove == 1 && playerMove == 3){
            tvResult.text = "You Win!"
        }
        else if (computerMove == 2 && playerMove == 1){
            tvResult.text = "You Win!"
        }
        else if (computerMove == 2 && playerMove == 3){
            tvResult.text = "Computer Wins!"
        }
        else if (computerMove == 3 && playerMove == 1){
            tvResult.text = "Computer Wins!"
        }
        else if (computerMove == 3 && playerMove == 2){
            tvResult.text = "You Win!"
        }
        //Add the game that has been played to the history database
        addGamesToDatabase()
    }

    //Start the scoreactivity
    private fun gotoHistory(){
        val intent = Intent(this,RockPaperScissorScoreActivity::class.java)
        startActivity(intent)
    }

    //Create the options menu with history
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_gotoHistory -> {
                gotoHistory()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
