package com.practice.ngitapp

import android.content.Intent
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.cardview.widget.CardView

class dashboard : AppCompatActivity() {
    lateinit var aboutCollege:CardView
    lateinit var collegeShedule:CardView
    lateinit var updateProfile:CardView
    lateinit var contactSuppprt:CardView
    lateinit var collegeLocation:CardView
    lateinit var logout_btn:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        aboutCollege = findViewById(R.id.dashboard_aboutCollege)
        collegeShedule = findViewById(R.id.dashboard_onlineClasses)
        contactSuppprt = findViewById(R.id.dashboard_contactSupport)
        collegeLocation = findViewById(R.id.dashboard_collegeLocation)
        logout_btn = findViewById(R.id.logOut_user)

        var uri:Uri

        aboutCollege.setOnClickListener{
            uri  = Uri.parse("http://ngit.ac.in/about-us.php")
            val intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }


        collegeShedule.setOnClickListener{
            val intent = Intent(this,CollegeShedule::class.java)
            startActivity(intent)

        }


        contactSuppprt.setOnClickListener{
            uri  = Uri.parse("http://ngit.ac.in/contact-us.php")
            val intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }

        collegeLocation.setOnClickListener{
            uri  = Uri.parse("https://www.google.com/maps?ll=17.413593,78.555148&z=12&t=m&hl=en-US&gl=IN&mapclient=embed&saddr=Keshav+Memorial+Institute+Of+Technology,+3-5-1026,+Narayanguda+Rd,+Hari+Vihar+Colony,+Bhawani+Nagar,+Narayanguda,+Hyderabad,+Telangana+500029&daddr=Neil+Gogte+Institute+of+Technology,+Survey+No+35+Peerzadiguda+Road+Uppal,+Kachawanisingaram+Village,+Hyderabad,+Telangana+500039&dirflg=d")
            val intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }


        logout_btn.setOnClickListener{
            intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}