package ru.kipdev.reminder.ui.new_task.geo_triggers.di

import androidx.core.util.Supplier
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import ru.kipdev.reminder.ui.new_task.geo_triggers.GeoTriggersFragment
import ru.kipdev.reminder.ui.new_task.geo_triggers.GeoTriggersViewModel
import ru.kipdev.reminder.utils.ViewModelProviderFactory

@Module
class GeoTriggersModule {
    @Provides
    fun provideGeoTriggersModel(fragment: GeoTriggersFragment): GeoTriggersViewModel {
        val supplier: Supplier<GeoTriggersViewModel> =
            Supplier {
                GeoTriggersViewModel()
            }
        val factory: ViewModelProviderFactory<GeoTriggersViewModel> =
            ViewModelProviderFactory(GeoTriggersViewModel::class.java, supplier)
        return ViewModelProvider(fragment, factory).get(GeoTriggersViewModel::class.java)
    }
}