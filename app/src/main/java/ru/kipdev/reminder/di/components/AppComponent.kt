package ru.kipdev.reminder.di.components

import android.app.Application
import ru.kipdev.reminder.MainApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import ru.kipdev.reminder.di.ReceiverModule
import ru.kipdev.reminder.di.modules.*
import javax.inject.Singleton


@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class, DatabaseModule::class, UseCaseModule::class, RepositoryModule::class, MainActivityFragmentModule::class, ReceiverModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: MainApplication)
}
