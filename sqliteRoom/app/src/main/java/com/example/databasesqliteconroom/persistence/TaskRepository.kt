package com.example.databasesqliteconroom.persistence

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.databasesqliteconroom.Model.Task
import com.example.databasesqliteconroom.database.TaskDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class TaskRepository {

    companion object{
        var userDatabase:TaskDatabase?=null

        private fun intialiseDB(context: Context): TaskDatabase?
        {
            return TaskDatabase.getInstance(context)!!
        }

        fun insert(context: Context,task:Task)
        {
            userDatabase= intialiseDB(context)

            CoroutineScope(IO).launch {
                userDatabase!!.taskDao().insert(task)
            }
        }

        fun getAllUserData(context: Context): LiveData<List<Task>>
        {
            userDatabase= intialiseDB(context)
            return userDatabase!!.taskDao().getAllTasks()
        }
    }
}