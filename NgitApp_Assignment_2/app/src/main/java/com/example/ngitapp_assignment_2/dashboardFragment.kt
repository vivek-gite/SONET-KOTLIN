package com.example.ngitapp_assignment_2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentActivity
import com.example.ngitapp_assignment_2.databinding.FragmentDashboardBinding


class dashboardFragment : Fragment(R.layout.fragment_dashboard) {

    lateinit var binding:FragmentDashboardBinding

    //views
    lateinit var aboutCollege: CardView
    lateinit var collegeShedule: CardView
    lateinit var updateProfile: CardView
    lateinit var contactSuppprt: CardView
    lateinit var collegeLocation: CardView
    lateinit var logout_btn: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDashboardBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var uri:Uri
        var intent:Intent
        aboutCollege = binding.dashboardAboutCollege
        collegeShedule = binding.dashboardOnlineClasses
        contactSuppprt = binding.dashboardContactSupport
        collegeLocation = binding.dashboardCollegeLocation

        aboutCollege.setOnClickListener {
            uri = Uri.parse("http://ngit.ac.in/about-us.php")
            intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }

        collegeShedule.setOnClickListener{
            var fm = activity?.supportFragmentManager
            var ft = fm?.beginTransaction()
            ft?.replace(R.id.fragmentContainerView,collegeSheduleFragment())
            ft?.commit()
        }


        contactSuppprt.setOnClickListener{
            uri  = Uri.parse("http://ngit.ac.in/contact-us.php")
            intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }

        collegeLocation.setOnClickListener{
            uri  = Uri.parse("https://www.google.com/maps?ll=17.413593,78.555148&z=12&t=m&hl=en-US&gl=IN&mapclient=embed&saddr=Keshav+Memorial+Institute+Of+Technology,+3-5-1026,+Narayanguda+Rd,+Hari+Vihar+Colony,+Bhawani+Nagar,+Narayanguda,+Hyderabad,+Telangana+500029&daddr=Neil+Gogte+Institute+of+Technology,+Survey+No+35+Peerzadiguda+Road+Uppal,+Kachawanisingaram+Village,+Hyderabad,+Telangana+500039&dirflg=d")
            intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }
    }


}