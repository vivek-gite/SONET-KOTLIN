package com.practice.myapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    var gameState = arrayOf(0,0,0,0,0,0,0,0,0)
    var activePlayer = 1 // 1- Black 2- White
    var turns = 0

    var gameActive = true
    var winPositions = arrayOf(arrayOf(0, 1, 2),arrayOf(3, 4, 5),arrayOf(6, 7, 8),arrayOf(0, 3, 6),arrayOf(1, 4, 7),
        arrayOf(2, 5, 8), arrayOf(0, 4, 8),arrayOf(2, 4, 6))

    private lateinit var textBox:TextView
    private lateinit var again:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textBox = findViewById(R.id.playerActive)
        again = findViewById(R.id.startAgain)
    }
    fun winCondition(x:Int,y:Int,z:Int):Boolean{
        return (x==y && y==z && x!=0)
    }

    fun coinAppear(view:View){
        again.visibility = View.VISIBLE

        var img:ImageView = view as ImageView
        var tag:Int = img.getTag().toString().toInt()



        if(gameState[tag] ==0 && gameActive){
            turns++

            gameState[tag] = activePlayer
            if(activePlayer == 1){
                img.setImageResource(R.drawable.black)
                activePlayer=2
            }
            else{
                img.setImageResource(R.drawable.white)
                activePlayer=1
            }
            textBox()
        }
        //Draw Condition
        if(turns == 9){
            textBox.setText("DRAW!!!").toString()

        }

        for(pos in winPositions){
            if(winCondition(gameState[pos[0]],gameState[pos[1]],gameState[pos[2]])){
                gameActive = false // After winning no other activity

                if(activePlayer==2){
                    textBox.setText("Black Won").toString()

                }
                else{
                    textBox.setText("White Won").toString()
                }
            }
        }

    }

    fun textBox(){

        if(activePlayer == 1){
            textBox.setText("Black Chance").toString()

        }
        else{
            textBox.setText("White Chance").toString()

        }
    }

    fun playAgain(view:View){
        again.visibility = View.GONE
        gameState = arrayOf(0,0,0,0,0,0,0,0,0)
        activePlayer = 1
        turns = 0
        gameActive = true


        findViewById<ImageView>(R.id.coin1).setImageResource(0)
        findViewById<ImageView>(R.id.coin2).setImageResource(0)
        findViewById<ImageView>(R.id.coin3).setImageResource(0)
        findViewById<ImageView>(R.id.coin4).setImageResource(0)
        findViewById<ImageView>(R.id.coin5).setImageResource(0)
        findViewById<ImageView>(R.id.coin6).setImageResource(0)
        findViewById<ImageView>(R.id.coin7).setImageResource(0)
        findViewById<ImageView>(R.id.coin8).setImageResource(0)
        findViewById<ImageView>(R.id.coin9).setImageResource(0)

        textBox.text = "Black's Turn - Tap to play"
    }
}