package ru.kipdev.reminder.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import ru.kipdev.local_data.TasksDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences("reminder.prefs", Context.MODE_PRIVATE)
    }
}