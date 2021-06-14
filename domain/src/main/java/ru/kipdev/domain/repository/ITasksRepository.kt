package ru.kipdev.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.kipdev.domain.model.Task


interface ITasksRepository {
    //fun insertTest(time: String, log: String)
    suspend fun getAllTasks(): Flow<List<Task>>
    suspend fun insertTask(task: Task)
}