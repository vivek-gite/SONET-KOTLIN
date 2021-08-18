package com.practice.ngitapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class classShedule_Adapter(
    var shedule: MutableList<classShedule>,
    val listener: OnItemClickListener
    ):RecyclerView.Adapter<classShedule_Adapter.classShedule_ViewHolder>(){

    //This viewholder is responsible to hold the views of our recyclerview
    inner class classShedule_ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        val classJoinText = itemView.findViewById<TextView>(R.id.class_join_text)
        val classJoinTiming = itemView.findViewById<TextView>(R.id.class_join_timing)
        val classJoinBtn = itemView.findViewById<TextView>(R.id.class_join_btn)

        init{
            classJoinBtn.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = absoluteAdapterPosition
            if(position!= RecyclerView.NO_POSITION){
                listener.onItemClick(position)
            }
        }
    }

    // This will create a new  layout for a particular view
    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): classShedule_ViewHolder {
        //LayoutInflater is used to create a new View (or Layout) object from one of your xml layouts.
        val context = parent.context
        // Inflate the custom layout
        val view = LayoutInflater.from(context).inflate(R.layout.attend_class,parent,false)
        // Return a new holder instance
        return classShedule_ViewHolder(view)
    }

    //The purpose of this function is to bind the data to our items so it takes data from 'shedule' list
    //and sets the view for the layout
    override fun onBindViewHolder(holder: classShedule_ViewHolder, position: Int) {
        holder.apply {
            val currentItem = shedule[position]
            classJoinText.text = currentItem.classText
            classJoinTiming.text = currentItem.classTimings

        }
    }

    //This is the size of the list
    override fun getItemCount(): Int {
        return shedule.size
    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }
}