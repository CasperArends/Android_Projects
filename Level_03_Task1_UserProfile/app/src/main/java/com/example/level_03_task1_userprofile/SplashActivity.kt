package com.example.level_03_task1_userprofile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivity(
                    Intent(
                        this@SplashActivity,
                        CreateProfileActivity::class.java
                    )
            )
            finish()
        }, 1000)


    }
}
