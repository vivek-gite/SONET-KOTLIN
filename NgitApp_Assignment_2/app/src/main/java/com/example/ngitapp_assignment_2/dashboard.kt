package com.example.ngitapp_assignment_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ngitapp_assignment_2.databinding.ActivityDashboardBinding

class dashboard : AppCompatActivity() {

    lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}