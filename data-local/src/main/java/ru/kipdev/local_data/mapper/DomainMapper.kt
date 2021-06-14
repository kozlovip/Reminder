package ru.kipdev.local_data.mapper

import ru.kipdev.domain.model.Task
import ru.kipdev.local_data.model.TaskEntityEmbedded

fun TaskEntityEmbedded.toDomain(): Task {
    return Task(task.id, task.name, null, null, null, null, null, null)
}