package com.example.ngitapp_assignment_2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.ngitapp_assignment_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var login_btn:Button
    lateinit var register_btn:Button


    val resultConstract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result: ActivityResult? ->
        if(result?.resultCode == Activity.RESULT_OK){
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        login_btn = binding.homeLoginBtn
        register_btn = binding.homeRegisterBtn

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