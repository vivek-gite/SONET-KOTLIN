package com.practice.ngitapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.coroutines.launch

class registeration_page : AppCompatActivity() {
    lateinit var registration_btn:Button
    lateinit var firstName:EditText
    lateinit var lastName:EditText
    lateinit var rollNumber:EditText
    lateinit var password:EditText
    lateinit var reg_login_text:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registeration_page)

        //This is used to delete the database table
//        this.deleteDatabase("sonet_db")

        registration_btn = findViewById(R.id.signUp_btn)
        firstName = findViewById(R.id.reg_first_name)
        lastName = findViewById(R.id.reg_last_name)
        rollNumber = findViewById(R.id.reg_roll_no)
        password = findViewById(R.id.reg_password)
        reg_login_text = findViewById(R.id.reg_login_text)

        reg_login_text.setOnClickListener {
            val loginPage = Intent(this,login_page::class.java)
            startActivity(loginPage)
            finish()
        }


        var config_db = Room.databaseBuilder(this,UserDatabase::class.java,"sonet.db")
        var db = config_db.build()

        val redirectLogin = Intent(this,login_page::class.java)

        var userCheck:List<User>?

        registration_btn.setOnClickListener {
            lifecycleScope.launch {
                if(firstName.text.toString()=="" || lastName.text.toString()==""
                    ||rollNumber.text.toString()==""|| password.text.toString()==""){
                    Toast.makeText(this@registeration_page,"Please fill all the details",Toast.LENGTH_SHORT).show()
                }
                else{
                    var dao = db.userDao()
                    userCheck = dao.fetchCredentials(rollNumber.text.toString())
                    //Here if there is no user exits then add the new user
                    if(userCheck.orEmpty().isEmpty()){ //orEmpty() will convert  object to empty list if the variable is 'null'
                        var user = User(0,firstName.text.toString(),lastName.text.toString(),
                            rollNumber.text.toString(),password.text.toString())
                        dao.insertUser(user)
                        startActivity(redirectLogin)
                        finish()
                    }
                    else{
                        Toast.makeText(this@registeration_page,"Roll Number Already Exits",Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }

    }
}