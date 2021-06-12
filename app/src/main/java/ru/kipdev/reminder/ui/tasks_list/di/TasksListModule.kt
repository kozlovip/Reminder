package ru.kipdev.reminder.ui.tasks_list.di

import androidx.core.util.Supplier
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import ru.kipdev.reminder.ui.tasks_list.TasksListFragment
import ru.kipdev.reminder.ui.tasks_list.TasksListViewModel
import ru.kipdev.reminder.utils.ViewModelProviderFactory

@Module
class TasksListModule {
    @Provides
    fun provideTasksListModel(fragment: TasksListFragment): TasksListViewModel {
        val supplier: Supplier<TasksListViewModel> =
            Supplier {
                TasksListViewModel()
            }
        val factory: ViewModelProviderFactory<TasksListViewModel> =
            ViewModelProviderFactory(TasksListViewModel::class.java, supplier)
        return ViewModelProvider(fragment, factory).get(TasksListViewModel::class.java)
    }
}