package ru.kipdev.reminder.di.modules

import dagger.Module
import dagger.Provides
import ru.kipdev.domain.repository.ITasksRepository
import ru.kipdev.domain.repository.ITestRepository
import ru.kipdev.domain.usecases.GetAllTasksUseCase
import ru.kipdev.domain.usecases.InsertTaskUseCase
import ru.kipdev.domain.usecases.InsertTestUseCase
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideInsertTestUseCase(repository: ITestRepository) : InsertTestUseCase = InsertTestUseCase(repository)

    @Provides
    @Singleton
    fun provideInsertTaskUseCase(repository: ITasksRepository) : InsertTaskUseCase = InsertTaskUseCase(repository)

    @Provides
    @Singleton
    fun provideGetAllTasksUseCase(repository: ITasksRepository) : GetAllTasksUseCase = GetAllTasksUseCase(repository)
}