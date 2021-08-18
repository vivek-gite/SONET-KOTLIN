package com.practice.myapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class FinalQuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_quiz)

        val user_name:String? = intent.getStringExtra("name")
        val user_score:String? = intent.getStringExtra("score")

        val userName = findViewById<TextView>(R.id.final_name)
        val userScore = findViewById<TextView>(R.id.final_score)
        val playAgain = findViewById<Button>(R.id.play_again)

        userName.text = user_name
        userScore.text = user_score
        playAgain.setOnClickListener{
            val intent = Intent(this,SonetQuiz::class.java)
            startActivity(intent)
            finish()
        }
    }
}