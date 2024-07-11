package com.dicoding.submissionakhirvgetables

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class AboutMe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_me)

        val backButton : ImageView = findViewById(R.id.back_button)
        backButton.setOnClickListener{
//            onBackPressed()
            onBackPressedDispatcher.onBackPressed()
        }

    }
}