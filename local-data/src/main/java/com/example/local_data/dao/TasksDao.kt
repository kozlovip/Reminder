package com.example.local_data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.local_data.model.TaskEmbedded
import kotlinx.coroutines.flow.Flow

@Dao
interface TasksDao {
    @Transaction
    @Query("SELECT * FROM tasks")
    fun getAll(): Flow<List<TaskEmbedded>>
}