package ru.kipdev.reminder.di.modules

import dagger.Module
import dagger.Provides
import ru.kipdev.domain.repository.ITestRepository
import ru.kipdev.domain.usecases.InsertTestUseCase
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideInsertTestUseCase(repository: ITestRepository) : InsertTestUseCase = InsertTestUseCase(repository)
}