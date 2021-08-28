package com.example.ngitapp_assignment_2

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ngitapp_assignment_2.databinding.FragmentCollegeSheduleBinding

class collegeSheduleFragment : Fragment(R.layout.fragment_college_shedule), classSheduleAdapter.OnItemClickListener {

    lateinit var binding:FragmentCollegeSheduleBinding
    lateinit var recyclerView:RecyclerView
    lateinit var spinner: Spinner
    lateinit var recyclerAdapter:classSheduleAdapter
    val sheduleList = mutableListOf<classSheduleEntity>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCollegeSheduleBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.rcv
        spinner = binding.spinner

        recyclerAdapter = classSheduleAdapter(sheduleList,this)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)


        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                when (p2) {
                    0 -> {
                        sheduleList.clear()
                        sheduleList.addAll(
                            mutableListOf(
                                classSheduleEntity("CO", "10:00-10:50"),
                                classSheduleEntity("DAA", "11:00-1:00"),
                                classSheduleEntity("DMBS", "2:00-3:40"),
                            )
                        )
                        recyclerAdapter.notifyDataSetChanged()
                    }
                    1 -> {

                        sheduleList.clear()
                        sheduleList.addAll(
                            mutableListOf(
                                classSheduleEntity("F & A", "9:00-9:50"),
                                classSheduleEntity("SS", "10:00-10:50"),
                                classSheduleEntity("JAVA", "11:00-1:00"),
                                classSheduleEntity("M3", "2:00-2:50"),
                                classSheduleEntity("CO", "3:00-3:40"),
                            )
                        )
                        recyclerAdapter.notifyDataSetChanged()
                    }
                    2 -> {
                        sheduleList.clear()
                        sheduleList.addAll(
                            mutableListOf(
                                classSheduleEntity("ETC", "10:00-10:50"),
                                classSheduleEntity("DAA", "11:00-1:00"),
                                classSheduleEntity("DMBS", "2:00-3:40"),
                            )
                        )
                        recyclerAdapter.notifyDataSetChanged()
                    }
                    3 -> {
                        sheduleList.clear()
                        sheduleList.addAll(
                            mutableListOf(
                                classSheduleEntity("M3", "10:00-10:50"),
                                classSheduleEntity("JAVA", "11:00-1:00"),
                                classSheduleEntity("F & A", "2:00-2:50"),
                                classSheduleEntity("SS", "3:00-3:40")
                            )
                        )
                        recyclerAdapter.notifyDataSetChanged()
                    }
                    4 -> {
                        sheduleList.clear()
                        sheduleList.addAll(
                            mutableListOf(
                                classSheduleEntity("DBMS", "9:00-10:50"),
                                classSheduleEntity("DAA", "11:00-1:00"),
                                classSheduleEntity("M3", "2:00-2:50"),
                                classSheduleEntity("ETC", "3:00-3:40"),
                            )
                        )
                        recyclerAdapter.notifyDataSetChanged()
                    }
                    5 -> {
                        sheduleList.clear()
                        sheduleList.addAll(
                            mutableListOf(
                                classSheduleEntity("CO", "10:00-10:50"),
                                classSheduleEntity("JAVA", "11:00-1:00"),
                                classSheduleEntity("SS", "2:00-2:50"),
                                classSheduleEntity("F & A", "2:50-3:40")
                            )
                        )
                        recyclerAdapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
    override fun onItemClick(position:Int){
        val uri = Uri.parse("http://ngitonline.com/login/index.php")
        val intent = Intent(Intent.ACTION_VIEW,uri)
        startActivity(intent)
    }

}