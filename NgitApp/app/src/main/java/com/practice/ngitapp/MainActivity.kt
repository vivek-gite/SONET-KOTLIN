package com.practice.ngitapp

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    lateinit var database: UserDatabase
    lateinit var login_btn:Button
    lateinit var register_btn:Button

    val resultConstract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result:ActivityResult? ->
        if(result?.resultCode == Activity.RESULT_OK){
            finish()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login_btn = findViewById(R.id.home_login_btn)
        register_btn = findViewById(R.id.home_register_btn)
        Log.i("position","WORKS gsrgrshhsrhhsrhsrh")
        login_btn.setOnClickListener {
            val loginPage: Intent = Intent(this,login_page::class.java)

            resultConstract.launch(loginPage)
        }
        register_btn.setOnClickListener {
            val registerationPage: Intent = Intent(this,registeration_page::class.java)
            startActivity(registerationPage)
        }
    }

}