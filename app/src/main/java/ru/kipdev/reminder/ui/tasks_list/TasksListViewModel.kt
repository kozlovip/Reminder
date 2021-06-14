package ru.kipdev.reminder.ui.tasks_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.withContext
import ru.kipdev.domain.model.Task
import ru.kipdev.domain.usecases.GetAllTasksUseCase
import ru.kipdev.domain.usecases.InsertTaskUseCase
import ru.kipdev.reminder.model.DataResult
import ru.kipdev.reminder.utils.BaseViewModel

class TasksListViewModel(val getAllTasksUseCase: GetAllTasksUseCase, val insertTaskUseCase: InsertTaskUseCase) : BaseViewModel(){

    val tasks: LiveData<DataResult<List<Task>?>>
        get() = _tasks

    private var _tasks = MutableLiveData<DataResult<List<Task>?>>()

    fun getAllTasks(){
        launchCoroutine(_tasks) {
            getAllTasksUseCase().collect {
                _tasks.value = DataResult.success(it)
            }
        }
    }

    val insertTaskViewState: LiveData<DataResult<List<Task>?>>
        get() = _insertTaskViewState

    private var _insertTaskViewState = MutableLiveData<DataResult<List<Task>?>>()

    fun insertTask(){
        launchCoroutine<Any> {
            withContext(Dispatchers.Default) { insertTaskUseCase(Task(0, "test1", null, null, null, null, null, null)) }
        }
    }
}