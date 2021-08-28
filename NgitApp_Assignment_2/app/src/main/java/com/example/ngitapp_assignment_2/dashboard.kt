package com.example.ngitapp_assignment_2

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.ngitapp_assignment_2.databinding.ActivityDashboardBinding

class dashboard : AppCompatActivity() {

    lateinit var binding: ActivityDashboardBinding
    lateinit var logoutBtn:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        logoutBtn = binding.logOutUser
        logoutBtn.setOnClickListener {
            intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}