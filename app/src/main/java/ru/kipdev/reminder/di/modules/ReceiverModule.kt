package ru.kipdev.reminder.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.kipdev.reminder.reciever.RebootReceiver

@Module
abstract class ReceiverModule {
    @ContributesAndroidInjector
    abstract fun bindRebootReceiver(): RebootReceiver
}