package ru.kipdev.local_data.mapper

import ru.kipdev.domain.model.Task
import ru.kipdev.local_data.model.TaskEntity

fun Task.toEntity(): TaskEntity{
    return TaskEntity(0, name)
}