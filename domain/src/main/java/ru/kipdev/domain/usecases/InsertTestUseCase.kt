package ru.kipdev.domain.usecases

import ru.kipdev.domain.repository.ITestRepository

class InsertTestUseCase (
    private val repository: ITestRepository
) {
    suspend operator fun invoke(time: String, log: String) = repository.insertTest(time, log)
}