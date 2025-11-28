package com.example.androidtask.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidtask.database.dao.TaskDAO
import com.example.androidtask.database.entity.TaskCollection
import com.example.androidtask.database.entity.TaskEntity

private const val DATABASE_NAME = "app.db"

@Database(
    entities = [TaskCollection::class, TaskEntity::class],
    version = 1
)
abstract class AppDb : RoomDatabase() {
    abstract fun taskDao(): TaskDAO

    companion object {
        @Volatile
        private var instance: AppDb? = null

        operator fun invoke(context: Context): AppDb {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }
        }

        private fun buildDatabase(context: Context): AppDb  = Room.databaseBuilder(
            context,
            AppDb::class.java,
            DATABASE_NAME
        ).build()
    }
}
