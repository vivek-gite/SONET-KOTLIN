package com.Practice.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var rollDice :ImageView //lateinit tells the compiler that before using the variable rollDice we will initialize
                    //it for sure so we are creating the variable rollDice here
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
//        rollButton.setOnClickListener{
//            Toast.makeText(this,"You Clicked Button", Toast.LENGTH_SHORT).show()
//
//        }
        rollButton.setOnClickListener{
            rollDice()
        }
        rollDice = findViewById(R.id.dice_Image) //Initializing rollDice
    }

    private fun rollDice() {
//        val rollText = findViewById<TextView>(R.id.dice_Image)
//        rollText.text = (Random.nextInt(6) +1).toString()

        val randomNum = Random.nextInt(6)+1

        val drawableResource = when(randomNum){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else -> R.drawable.dice_6
        }

//        val rollDice: ImageView = findViewById(R.id.dice_Image) //As we always initialize this variable while calling rollDice()
                                //Due to this it always makes search for the id so to avoid that we initalize only once above.
        rollDice.setImageResource(drawableResource)
        Toast.makeText(this,"The Dice is ${randomNum}",Toast.LENGTH_SHORT).show()
    }
}