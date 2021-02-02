package com.example.local_data.repository

import com.example.domain.repository.ITasksRepository
import com.example.local_data.dao.TasksDao

class TasksRepository(private val tasksDao: TasksDao) : ITasksRepository {
}