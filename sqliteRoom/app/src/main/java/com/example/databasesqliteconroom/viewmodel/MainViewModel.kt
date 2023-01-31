package com.example.databasesqliteconroom.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.databasesqliteconroom.Model.Task
import com.example.databasesqliteconroom.database.TaskDatabase
import com.example.databasesqliteconroom.persistence.TaskRepository

class MainViewModel() : ViewModel() {
    fun insert(context: Context,task: Task)
    {
        TaskRepository.insert(context,task)
    }

    fun getAllUserData(context: Context): LiveData<List<Task>>
    {
        return TaskRepository.getAllUserData(context)
    }
}
