package com.practice.ngitapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CollegeShedule : AppCompatActivity(), classShedule_Adapter.OnItemClickListener {
    lateinit var spinner:Spinner
    lateinit var recyclerView:RecyclerView
    lateinit var recyclerAdapter:classShedule_Adapter

    val sheduleList = mutableListOf<classShedule>()

    override fun onCreate(savedInstanceState: Bundle?) {
//        val weekdays = listOf<String>("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_college_shedule)

        recyclerView = findViewById<RecyclerView>(R.id.rcv)
        spinner = findViewById(R.id.spinner)


        recyclerAdapter = classShedule_Adapter(sheduleList,this)

        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                when (p2) {
                    0 -> {

                        sheduleList.clear()
                        sheduleList.addAll(
                            mutableListOf(
                                classShedule("CO", "10:00-10:50"),
                                classShedule("DAA", "11:00-1:00"),
                                classShedule("DMBS", "2:00-3:40"),
                            )
                        )
                        recyclerAdapter.notifyDataSetChanged()
                    }
                    1 -> {

                        sheduleList.clear()
                        sheduleList.addAll(
                            mutableListOf(
                                classShedule("F & A", "9:00-9:50"),
                                classShedule("SS", "10:00-10:50"),
                                classShedule("JAVA", "11:00-1:00"),
                                classShedule("M3", "2:00-2:50"),
                                classShedule("CO", "3:00-3:40"),
                            )
                        )
                        recyclerAdapter.notifyDataSetChanged()
                    }
                    2 -> {
                        sheduleList.clear()
                        sheduleList.addAll(
                            mutableListOf(
                                classShedule("ETC", "10:00-10:50"),
                                classShedule("DAA", "11:00-1:00"),
                                classShedule("DMBS", "2:00-3:40"),
                            )
                        )
                        recyclerAdapter.notifyDataSetChanged()
                    }
                    3 -> {
                        sheduleList.clear()
                        sheduleList.addAll(
                            mutableListOf(
                                classShedule("M3", "10:00-10:50"),
                                classShedule("JAVA", "11:00-1:00"),
                                classShedule("F & A", "2:00-2:50"),
                                classShedule("SS", "3:00-3:40")
                            )
                        )
                        recyclerAdapter.notifyDataSetChanged()
                    }
                    4 -> {
                        sheduleList.clear()
                        sheduleList.addAll(
                            mutableListOf(
                                classShedule("DBMS", "9:00-10:50"),
                                classShedule("DAA", "11:00-1:00"),
                                classShedule("M3", "2:00-2:50"),
                                classShedule("ETC", "3:00-3:40"),
                            )
                        )
                        recyclerAdapter.notifyDataSetChanged()
                    }
                    5 -> {
                        sheduleList.clear()
                        sheduleList.addAll(
                            mutableListOf(
                                classShedule("CO", "10:00-10:50"),
                                classShedule("JAVA", "11:00-1:00"),
                                classShedule("SS", "2:00-2:50"),
                                classShedule("F & A", "2:50-3:40")
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

    override fun onItemClick(position: Int) {
        val uri = Uri.parse("http://ngitonline.com/login/index.php")
        val intent = Intent(Intent.ACTION_VIEW,uri)
        startActivity(intent)
    }

}