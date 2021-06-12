package ru.kipdev.reminder.di.modules

import dagger.Module
import dagger.Provides
import ru.kipdev.domain.repository.ITestRepository
import ru.kipdev.local_data.dao.TestDao
import ru.kipdev.local_data.repository.TestRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideTestRepository(testDao: TestDao) : TestRepository =
        TestRepository(testDao)

    @Provides
    @Singleton
    fun provideTestInterfaceRepository(rep: TestRepository) : ITestRepository = rep

}