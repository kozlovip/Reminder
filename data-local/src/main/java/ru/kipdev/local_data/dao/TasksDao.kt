package ru.kipdev.local_data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import ru.kipdev.local_data.model.TaskEntityEmbedded
import kotlinx.coroutines.flow.Flow
import ru.kipdev.local_data.model.TaskEntity

@Dao
interface TasksDao : BaseDao<TaskEntity> {
    @Transaction
    @Query("SELECT * FROM tasks")
    fun getAll(): Flow<List<TaskEntityEmbedded>>
}