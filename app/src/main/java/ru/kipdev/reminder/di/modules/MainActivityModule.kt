package ru.kipdev.reminder.di.modules

import androidx.core.util.Supplier
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import ru.kipdev.reminder.activities.main.MainActivity
import ru.kipdev.reminder.activities.main.MainActivityViewModel
import ru.kipdev.reminder.utils.ViewModelProviderFactory

@Module
class MainActivityModule {
    @Provides
    fun provideMainActivityViewModel(activity: MainActivity): MainActivityViewModel {
        val supplier: Supplier<MainActivityViewModel> =
            Supplier {
                MainActivityViewModel()
            }
        val factory: ViewModelProviderFactory<MainActivityViewModel> =
            ViewModelProviderFactory(MainActivityViewModel::class.java, supplier)
        return ViewModelProvider(activity, factory).get(MainActivityViewModel::class.java)
    }
}