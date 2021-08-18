package com.practice.ngitapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.coroutines.launch

class login_page : AppCompatActivity() {
    lateinit var rollNo:EditText
    lateinit var password:EditText
    lateinit var login_btn:Button
    lateinit var login_register_text:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        rollNo = findViewById(R.id.login_rollno)
        password = findViewById(R.id.login_password)
        login_btn = findViewById(R.id.login_button)
        login_register_text = findViewById(R.id.log_register_text)

        login_register_text.setOnClickListener {
            val registerationPage = Intent(this,registeration_page::class.java)
            startActivity(registerationPage)
            finish()
        }
        var config_db = Room.databaseBuilder(this,UserDatabase::class.java,"sonet.db")
        var db = config_db.build()
        var intent:Intent = Intent(this,dashboard::class.java)
        var authorize:Boolean = false

        login_btn.setOnClickListener {
            if(rollNo.text.toString() == "" || rollNo.text.toString().length<12){
                Toast.makeText(this,"Please enter a valid Roll Number",Toast.LENGTH_SHORT).show()
            }
            else{
                lifecycleScope.launch{
                    var userCredentials = db.userDao().fetchCredentials(rollNo.text.toString())

                    if(userCredentials.orEmpty().isEmpty()){
                        Toast.makeText(this@login_page,"First Register with this Roll Number",Toast.LENGTH_SHORT).show()
                    }
                    else if(userCredentials.get(0).password == password.text.toString()){
                        setResult(Activity.RESULT_OK)
                        startActivity(intent)
                        finish()
                    }
                    else{
                        Toast.makeText(this@login_page,"Incorrect Roll Number or Password",Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

    }
}