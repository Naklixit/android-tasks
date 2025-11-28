package com.example.androidtask.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
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

    @Query("UPDATE task SET  is_favourite = :isFavourite where id = :taskId")
    suspend fun updateTaskFavourite(taskId:Int, isFavourite: Boolean)

    @Query("UPDATE task SET  is_completed = :isCompleted where id = :taskId")
    suspend fun updateTaskCompleted(taskId:Int, isCompleted: Boolean)

    @Query("UPDATE task_collection SET title = :title where id = :collectionId")
    suspend fun updateCollectionTitle(collectionId:Int, title: String)
    @Update
    suspend fun updateTaskCollection(taskCollection: TaskCollection)
    @Update
    suspend fun updateTask(task: TaskEntity)
    @Delete
    suspend fun deleteTaskCollection(taskCollection: TaskCollection)
    @Delete
    suspend fun deleteTask(task: TaskEntity)
}