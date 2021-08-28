package com.example.ngitapp_assignment_2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class classSheduleAdapter(
    var shedule: MutableList<classSheduleEntity>,
    var listener: OnItemClickListener
    ):RecyclerView.Adapter<classSheduleAdapter.classShedule_ViewHolder>() {



        inner class classShedule_ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),View.OnClickListener{

            // Your holder should contain and initialize a member variable
            // for any view that will be set as you render a row
            val classJoinText = itemView.findViewById<TextView>(R.id.class_join_text)
            val classJoinTiming = itemView.findViewById<TextView>(R.id.class_join_timing)
            val classJoinBtn = itemView.findViewById<TextView>(R.id.class_join_btn)

            init{
                classJoinBtn.setOnClickListener(this)
            }

            override fun onClick(p0: View?) {
                val position = absoluteAdapterPosition// gets item position
                if(position!= RecyclerView.NO_POSITION){
                    listener.onItemClick(position)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): classShedule_ViewHolder {
        val context = parent.context

        val view = LayoutInflater.from(context).inflate(R.layout.activity_class,parent,false) //Here attachToRoot:false means we do not want our layout to
    // attach to the root of the layout permanently, it must recycle as we scroll.

        return classShedule_ViewHolder(view)
    }

    override fun onBindViewHolder(holder: classShedule_ViewHolder, position: Int) {
        holder.apply {
            val currentItem = shedule[position]
            classJoinText.text = currentItem.classText
            classJoinTiming.text = currentItem.classTiming
        }
    }

    override fun getItemCount(): Int {
        return shedule.size
    }
    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }
}