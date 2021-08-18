package com.practie.myapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.practice.myapps.*

class QuizActivity : AppCompatActivity() {

    private var listOfQuesions: ArrayList<Questions>? = null
    var currentPosition = 1
    lateinit var questions:TextView
    lateinit var optionOne:TextView
    lateinit var optionTwo:TextView
    lateinit var optionThree:TextView
    lateinit var optionFour:TextView
    lateinit var submitNextButton:Button
    lateinit var progressBar: ProgressBar
    lateinit var endButton: Button

    var score:Int = 0
    var selected:Int =0
    var name:String = ""
    lateinit var optionsList:List<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)


        //This is used to get the data from another activity. By this one activity can communicate with one another.
        //You can use intent.getSerializableExtra("name").toString() (or) getIntent().getSerializableExtra("name").toString()
        name = intent.getStringExtra("name").toString()
        var q_name = findViewById<TextView>(R.id.q_username)
        q_name.text = name

        var utility = Utility()
        listOfQuesions = utility.getQuestions()


        questions = findViewById<TextView>(R.id.q_question)
        optionOne = findViewById<TextView>(R.id.option_one)
        optionTwo = findViewById<TextView>(R.id.option_two)
        optionThree = findViewById<TextView>(R.id.option_three)
        optionFour = findViewById<TextView>(R.id.option_four)
        submitNextButton = findViewById(R.id.next_btn)
        progressBar = findViewById(R.id.progress_bar)
        endButton = findViewById(R.id.end_btn)

        progressBar.max = listOfQuesions!!.size
        progressBar.progress = currentPosition

        setQuestions()

        optionsList = listOf(optionOne,optionTwo,optionThree,optionFour)


        for(options in optionsList){
            options.setOnClickListener {
                doAction(it)
            }
        }

        endButton.setOnClickListener {
            finalPage()
        }



        submitNextButton.setOnClickListener {
            var ans = listOfQuesions!!.get(currentPosition-1).answer

            var btnText = submitNextButton.text.toString()
            when(btnText){
                "SUBMIT" -> {
                    checkAnswer(ans,selected)
                    for(option in optionsList){
                        //We can also use option.setClickable(false)
                        option.setOnClickListener(null) //This is used to disable the listener
                    }
                    if(listOfQuesions!!.size == currentPosition){
                        submitNextButton.text = "FINISH"
                    }
                    else{
                        submitNextButton.text = "NEXT"
                    }

                }
                "NEXT" -> {
                    currentPosition++
                    for(options in optionsList){
                        //We can also use options.setClickable(true)
                        options.setOnClickListener {
                            doAction(it)
                        }
                    }
                    setQuestions()
                    defaultOption()
                    submitNextButton.text = "SUBMIT"
                    progressBar.progress = currentPosition

                }
                "FINISH" -> {

                    finalPage()
                }
            }

        }
    }

    fun setQuestions(){
        val questionObject = listOfQuesions!!.get(currentPosition-1)

        questions.text = questionObject.question
        optionOne.text = questionObject.optOne
        optionTwo.text = questionObject.optTwo
        optionThree.text = questionObject.optThree
        optionFour.text = questionObject.optFour
    }

    fun doAction(v : View?){
        when(v?.id){
            R.id.option_one-> {
                selected = 1
                selectOption(optionsList.get(0))
            }
            R.id.option_two-> {
                selected = 2
                selectOption(optionsList.get(1))
            }
            R.id.option_three-> {
                selected = 3
                selectOption(optionsList.get(2))
            }
            R.id.option_four-> {
                selected = 4
                selectOption(optionsList.get(3))
            }
        }
    }

    private fun checkAnswer(ans:Int, select:Int){
//        when(select){
//            1->{
//                optionsList.get(select-1).background = ContextCompat.getDrawable(this,R.drawable.wrong_option)
//                optionsList.get(ans-1).background = ContextCompat.getDrawable(this,R.drawable.right_option)
//            }
//            2->{
//                optionsList.get(select-1).background = ContextCompat.getDrawable(this,R.drawable.wrong_option)
//                optionsList.get(ans-1).background = ContextCompat.getDrawable(this,R.drawable.right_option)
//            }
//            3->{
//                optionsList.get(select-1).background = ContextCompat.getDrawable(this,R.drawable.wrong_option)
//                optionsList.get(ans-1).background = ContextCompat.getDrawable(this,R.drawable.right_option)
//            }
//            4->{
//                optionsList.get(select-1).background = ContextCompat.getDrawable(this,R.drawable.wrong_option)
//                optionsList.get(ans-1).background = ContextCompat.getDrawable(this,R.drawable.right_option)
//            }
//            else ->{
//                Toast.makeText(this,"Please select any option",Toast.LENGTH_SHORT).show()
//            }
//        }
        optionsList.get(select-1).background = ContextCompat.getDrawable(this,R.drawable.wrong_option)
        optionsList.get(ans-1).background = ContextCompat.getDrawable(this,R.drawable.right_option)

        if(ans == select){
            score++
        }
    }
    private fun selectOption(t:TextView){
        defaultOption()
        t.background = ContextCompat.getDrawable(this,R.drawable.selected_option)
    }

    private fun defaultOption(){
        optionOne.background = ContextCompat.getDrawable(this,R.drawable.default_option)
        optionTwo.background = ContextCompat.getDrawable(this,R.drawable.default_option)
        optionThree.background = ContextCompat.getDrawable(this,R.drawable.default_option)
        optionFour.background = ContextCompat.getDrawable(this,R.drawable.default_option)

    }

    private fun finalPage(){
        val intent = Intent(this,FinalQuizActivity::class.java)
        intent.putExtra("score",score.toString())
        intent.putExtra("name",name)
        startActivity(intent)
        finish()
    }
}