package ru.kipdev.reminder.ui.tasks_list

import android.os.Bundle
import android.view.View
import ru.kipdev.reminder.R
import ru.kipdev.reminder.databinding.FragmentTasksListBinding
import ru.kipdev.reminder.manager.TasksManager
import ru.medicalapps.medicalapps.demo.utils.BaseViewModelFragment
import javax.inject.Inject

class TasksListFragment : BaseViewModelFragment<FragmentTasksListBinding, TasksListViewModel>() {

    override val layoutId: Int
        get() = R.layout.fragment_tasks_list

    override val navigationId: Int
        get() = R.id.navigation_tasks_list


    @Inject
    lateinit var tasksManager: TasksManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tasksManager.insertTest("tasks list")
    }

}