package ru.kipdev.reminder.di.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.kipdev.local_data.TestDatabase
import ru.kipdev.local_data.dao.TestDao
import javax.inject.Singleton

@Module
class DatabaseModule {

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
}