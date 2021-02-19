package ru.kipdev.reminder.di.components

import android.app.Application
import ru.kipdev.reminder.MainApplication
import ru.kipdev.reminder.di.modules.ActivityBuilder
import ru.kipdev.reminder.di.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: MainApplication)
}
