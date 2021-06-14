package ru.kipdev.reminder.ui.tasks_list.di

import androidx.core.util.Supplier
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import ru.kipdev.domain.usecases.GetAllTasksUseCase
import ru.kipdev.domain.usecases.InsertTaskUseCase
import ru.kipdev.reminder.ui.tasks_list.TasksListFragment
import ru.kipdev.reminder.ui.tasks_list.TasksListViewModel
import ru.kipdev.reminder.utils.ViewModelProviderFactory

@Module
class TasksListModule {
    @Provides
    fun provideTasksListModel(fragment: TasksListFragment, getAllTasksUseCase: GetAllTasksUseCase, insertTaskUseCase: InsertTaskUseCase): TasksListViewModel {
        val supplier: Supplier<TasksListViewModel> =
            Supplier {
                TasksListViewModel(getAllTasksUseCase, insertTaskUseCase)
            }
        val factory: ViewModelProviderFactory<TasksListViewModel> =
            ViewModelProviderFactory(TasksListViewModel::class.java, supplier)
        return ViewModelProvider(fragment, factory).get(TasksListViewModel::class.java)
    }
}