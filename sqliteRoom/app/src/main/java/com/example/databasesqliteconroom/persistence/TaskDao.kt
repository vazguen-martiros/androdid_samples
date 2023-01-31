package com.example.databasesqliteconroom.persistence

import androidx.annotation.RequiresPermission.Write
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.databasesqliteconroom.Model.Task

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert( vararg task: Task)
    @Update
    fun update(task: Task)

    @Delete
    fun delete(task: Task)

    @Query("SELECT * FROM task_table")
    fun getAllTasks(): LiveData<List<Task>>

}
