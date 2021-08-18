package com.practice.myapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.practie.myapps.QuizActivity

class SonetQuiz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sonet_quiz)

        val q_btn = findViewById<Button>(R.id.quiz_btn);
        val q_name = findViewById<EditText>(R.id.user_name);

        q_btn.setOnClickListener{
            if(q_name.text.toString() == ""){
                Toast.makeText(this,"Please Enter Your Name",Toast.LENGTH_SHORT).show();
            }
            else{
                val next:Intent = Intent(this, QuizActivity::class.java)// Here QuizActivity must be initialized
                //so to do this we can create an object of QuizActivity or use .class file

                //putExtra(name,value)- Add extended data to the intent. This is used to pass data with an application from
                //one activity to another. 'name' is like a variable for the 'value'.
                next.putExtra("name", q_name.text.toString())

                startActivity(next)
                //finish() - This will terminate the previous activity so if we click back then it will close the application
                    //If we dont use finish then if we click back then it will get back to previous activity
//                finish(); // If we wanna to compromise with the speed of the application then use finish
                          // If we wanna to compromise with the memory of the application then do not use finish
            }
        }
    }
}