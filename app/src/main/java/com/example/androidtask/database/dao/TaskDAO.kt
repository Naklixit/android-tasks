package com.example.androidtask.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.androidtask.database.entity.TaskCollection
import com.example.androidtask.database.entity.TaskEntity

@Dao
interface TaskDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTaskCollection(taskCollection: TaskCollection)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: TaskEntity)

    @Query("SELECT * from task_collection")
    suspend fun getTaskCollection(): List<TaskCollection>

    @Query("SELECT * from task where collection_id  = :collectionId")
    suspend fun getTasks(collectionId: Int): List<TaskEntity>

    @Query("UPDATE task SET title = :title where id = :taskId")
    suspend fun updateTaskTitle(taskId:Int, title: String)
}