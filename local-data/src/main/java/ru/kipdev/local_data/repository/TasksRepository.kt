package ru.kipdev.local_data.repository

import ru.kipdev.domain.repository.ITasksRepository
import ru.kipdev.local_data.dao.TasksDao

class TasksRepository(private val tasksDao: TasksDao) : ITasksRepository {
}