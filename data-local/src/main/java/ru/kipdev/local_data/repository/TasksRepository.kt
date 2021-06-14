package ru.kipdev.local_data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import ru.kipdev.domain.model.Task
import ru.kipdev.domain.repository.ITasksRepository
import ru.kipdev.local_data.dao.*
import ru.kipdev.local_data.mapper.toDomain
import ru.kipdev.local_data.mapper.toEntity

class TasksRepository(private val tasksDao: TasksDao,
                      private val declineConditionDao: DeclineConditionDao,
                      private val declineReiterationDao: DeclineReiterationDao,
                      private val dismissReiterationDao: DismissReiterationDao,
                      private val geoTriggerDao: GeoTriggerDao,
                      private val placeDao: PlaceDao,
                      private val placeTriggerDao: PlaceTriggerDao,
                      private val timeTriggerDao: TimeTriggerDao) : ITasksRepository {
    override suspend fun getAllTasks(): Flow<List<Task>> {
        return tasksDao.getAll().map { it.map { entity -> entity.toDomain() } }
    }

    override suspend fun insertTask(task: Task) {
        tasksDao.insert(task.toEntity())
    }
}