package ru.kipdev.reminder.di.modules

import dagger.Module
import dagger.Provides
import ru.kipdev.domain.repository.ITasksRepository
import ru.kipdev.domain.repository.ITestRepository
import ru.kipdev.local_data.dao.*
import ru.kipdev.local_data.repository.TasksRepository
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

    @Provides
    @Singleton
    fun provideTasksRepository(tasksDao: TasksDao,
                               declineConditionDao: DeclineConditionDao,
                               declineReiterationDao: DeclineReiterationDao,
                               dismissReiterationDao: DismissReiterationDao,
                               geoTriggerDao: GeoTriggerDao,
                               placeDao: PlaceDao,
                               placeTriggerDao: PlaceTriggerDao,
                               timeTriggerDao: TimeTriggerDao
    ) : TasksRepository =
        TasksRepository(tasksDao, declineConditionDao, declineReiterationDao, dismissReiterationDao, geoTriggerDao, placeDao, placeTriggerDao, timeTriggerDao)

    @Provides
    @Singleton
    fun provideTasksInterfaceRepository(rep: TasksRepository) : ITasksRepository = rep

}