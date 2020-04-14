package com.example.rockpaperscissors

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_rock_paper_scissore_score.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RockPaperScissorScoreActivity : AppCompatActivity() {


    private val history = arrayListOf<RockPaperScissor>()
    private val rpsAdapter = RockPaperScissorAdapter(history)
    private lateinit var rpsRepository : RockPaperScissorRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rock_paper_scissore_score)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        rpsRepository = RockPaperScissorRepository(this)

        initViews()
    }

    private fun initViews(){
        rvScores.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvScores.adapter = rpsAdapter
        rvScores.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        getGamesFromDatabase()

    }

    private fun deleteHistory(){
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.IO){
                rpsRepository.deleteAllGames()
            }
            getGamesFromDatabase()
        }
    }

    private fun getGamesFromDatabase(){
        CoroutineScope(Dispatchers.Main).launch {
            val resultList = withContext(Dispatchers.IO){
                rpsRepository.getAllGames()
            }
            this@RockPaperScissorScoreActivity.history.clear()
            this@RockPaperScissorScoreActivity.history.addAll(resultList)
            this@RockPaperScissorScoreActivity.rpsAdapter.notifyDataSetChanged()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_deleteHistory -> {
                deleteHistory()
                true
            }
            android.R.id.home -> {
                val resultIntent = Intent()
                setResult(Activity.RESULT_OK,resultIntent)
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_history, menu)
        return true
    }
}
