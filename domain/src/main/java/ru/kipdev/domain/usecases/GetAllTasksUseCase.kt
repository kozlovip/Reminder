package ru.kipdev.domain.usecases

import ru.kipdev.domain.repository.ITasksRepository

class GetAllTasksUseCase (
    private val repository: ITasksRepository
) {
    suspend operator fun invoke() = repository.getAllTasks()
}