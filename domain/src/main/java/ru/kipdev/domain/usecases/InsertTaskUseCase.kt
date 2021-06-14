package ru.kipdev.domain.usecases

import ru.kipdev.domain.model.Task
import ru.kipdev.domain.repository.ITasksRepository

class InsertTaskUseCase (
    private val repository: ITasksRepository
) {
    suspend operator fun invoke(task: Task) = repository.insertTask(task)
}