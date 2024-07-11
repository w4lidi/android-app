package com.dicoding.submissionakhirvgetables

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val handler = Handler()
        handler.postDelayed({
            val mainActivity = Intent(this@SplashScreen, MainActivity::class.java)
            startActivity(mainActivity)
            finish()
        },3000)

    }
}