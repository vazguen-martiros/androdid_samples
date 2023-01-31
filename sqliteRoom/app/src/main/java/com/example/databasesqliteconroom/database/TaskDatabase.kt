package com.example.databasesqliteconroom.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.databasesqliteconroom.Model.Task
import com.example.databasesqliteconroom.iu.MainActivity
import com.example.databasesqliteconroom.persistence.TaskDao

@Database(
    entities = [Task::class],
    version = 1
)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao

    companion object{
        @Volatile
        var instance:TaskDatabase?=null
        private const val DATABASE_NAME="DB_TASKS"

        fun getInstance(context: Context):TaskDatabase?
        {
            if(instance == null)
            {
                synchronized(TaskDatabase::class.java)
                {
                    if(instance == null)
                    {
                        instance= Room.databaseBuilder(context,TaskDatabase::class.java,
                            DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }

            return instance
        }

    }
}
