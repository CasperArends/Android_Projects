package com.example.example_level_02_reminder

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add.*

const val EXTRA_REMINDER = "EXTRA_REMINDER"

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(toolbar)
        // Get a support ActionBar corresponding to this toolbar and enable the Up button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initViews()
    }

    private fun initViews(){
        fabAddActivity.setOnClickListener {
            onSaveClick()
        }
    }

    private fun onSaveClick(){
        if (etAddReminder.text.toString().isNotBlank()){
            val reminder = Reminder(etAddReminder.text.toString())
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_REMINDER, reminder)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }else{
            Toast.makeText(this, "Cannot be empty!", Toast.LENGTH_SHORT).show()
        }
    }
}