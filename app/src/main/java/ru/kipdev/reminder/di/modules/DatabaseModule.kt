package ru.kipdev.reminder.di.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.kipdev.local_data.TasksDatabase
import ru.kipdev.local_data.TestDatabase
import ru.kipdev.local_data.dao.*
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideTasksDatabase(context: Context): TasksDatabase {
        return Room
            .databaseBuilder(context, TasksDatabase::class.java, "tasks_db")
            .build()
    }

    @Provides
    @Singleton
    fun provideTestDatabase(context: Context): TestDatabase {
        return Room
            .databaseBuilder(context, TestDatabase::class.java, "test_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideTestDao(db: TestDatabase): TestDao {
        return db.testDao()
    }

    @Provides
    @Singleton
    fun provideTaskDao(db: TasksDatabase): TasksDao {
        return db.tasksDao()
    }

    @Provides
    @Singleton
    fun provideDeclineConditionDao(db: TasksDatabase): DeclineConditionDao {
        return db.declineConditionDao()
    }

    @Provides
    @Singleton
    fun provideDeclineReiterationDao(db: TasksDatabase): DeclineReiterationDao {
        return db.declineReiterationDao()
    }

    @Provides
    @Singleton
    fun provideDismissReiterationDao(db: TasksDatabase): DismissReiterationDao {
        return db.dismissReiterationDao()
    }

    @Provides
    @Singleton
    fun provideGeoTriggerDao(db: TasksDatabase): GeoTriggerDao {
        return db.geoTriggerDao()
    }

    @Provides
    @Singleton
    fun providePlaceDao(db: TasksDatabase): PlaceDao {
        return db.placeDao()
    }

    @Provides
    @Singleton
    fun providePlaceTriggerDao(db: TasksDatabase): PlaceTriggerDao {
        return db.placeTriggerDao()
    }

    @Provides
    @Singleton
    fun provideTimeTriggerDao(db: TasksDatabase): TimeTriggerDao {
        return db.timeTriggerDao()
    }
}