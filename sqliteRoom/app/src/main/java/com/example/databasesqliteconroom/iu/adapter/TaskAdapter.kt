package com.example.databasesqliteconroom.iu.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.databasesqliteconroom.Model.Task
import com.example.databasesqliteconroom.R

class TaskAdapter  (private val context: Context, private var userList:ArrayList<Task>) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.task_item,parent,false))
    }

    override fun getItemCount(): Int =userList.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task:Task=userList[position]
        holder.titleTextView.text=task.title
        holder.descriptionTextView.text=task.description.toString()
        holder.completedCheckBox.text=task.completed.toString()
    }

    fun setData(userList:ArrayList<Task>)
    {
        this.userList=userList
        notifyDataSetChanged()
    }

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView = itemView.findViewById<TextView>(R.id.title_textView)
        val descriptionTextView = itemView.findViewById<TextView>(R.id.description_textView)
        val completedCheckBox = itemView.findViewById<CheckBox>(R.id.completed_checkBox)

        fun render(task: Task) {
            titleTextView.text = task.title
            descriptionTextView.text = task.description
            completedCheckBox.isChecked = task.completed == true
        }
    }
}