package com.example.databasesqliteconroom.iu

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.databasesqliteconroom.Model.Task
import com.example.databasesqliteconroom.R
import com.example.databasesqliteconroom.iu.adapter.TaskAdapter
import com.example.databasesqliteconroom.database.TaskDatabase
import com.example.databasesqliteconroom.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    companion object{

        lateinit var database: TaskDatabase
    }

    private  lateinit  var recyclerVievTareas:RecyclerView

    private lateinit var taskAdapter: TaskAdapter

    lateinit var title:TextView
    lateinit var descripcion:TextView
    lateinit var isCompleted:Switch

    private lateinit var taskViewModel: MainViewModel


    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = findViewById(R.id.editTvTitulo)
        descripcion =  findViewById(com.example.databasesqliteconroom.R.id.editTvDescription)
        isCompleted = findViewById(R.id.switchIsCompeted)


        recyclerVievTareas = findViewById<RecyclerView>(R.id.task_recycler_view)
        taskAdapter = TaskAdapter(this,ArrayList<Task>())

        recyclerVievTareas.layoutManager = LinearLayoutManager(this)

        recyclerVievTareas.apply {
            setHasFixedSize(true)
            layoutManager=LinearLayoutManager(this@MainActivity)
            adapter=taskAdapter
        }
        taskViewModel= ViewModelProvider(this).get(MainViewModel::class.java)
        taskViewModel.getAllUserData(this).observe(this, Observer {
            taskAdapter.setData(it as ArrayList<Task>)
        })


        //Save info
        findViewById<Button>(R.id.button).setOnClickListener{
            try {
                val task:Task =Task(0,title.text.toString(), description = descripcion.text.toString(),isCompleted.isChecked)
                title.text=""
                descripcion.text=""
                isCompleted.isChecked = false

                taskViewModel.insert(this,task)

            }
            catch (e:java.lang.Exception){
                Log.e("DB_DAO_ERROR",e.message.toString())
            }


        }
    }
}
