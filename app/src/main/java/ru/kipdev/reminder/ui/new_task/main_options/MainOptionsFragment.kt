package ru.kipdev.reminder.ui.new_task.main_options

import android.os.Bundle
import android.view.View
import ru.kipdev.reminder.R
import ru.kipdev.reminder.adapters.createTaskOptionAdapter
import ru.kipdev.reminder.databinding.FragmentMainOptionsBinding
import ru.kipdev.reminder.utils.BaseViewModelFragment

class MainOptionsFragment : BaseViewModelFragment<FragmentMainOptionsBinding, MainOptionsViewModel>() {

    override val layoutId: Int
        get() = R.layout.fragment_main_options

    override val navigationId: Int
        get() = R.id.navigation_new_task

    private val taskOptionAdapter by lazy {
        createTaskOptionAdapter{
            if(it.id == 1) safeNavigate(MainOptionsFragmentDirections.actionNavigationNewTaskToNavigationPlaceTriggers())
            else safeNavigate(MainOptionsFragmentDirections.actionNavigationNewTaskToNavigationTimeOptions())
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvOptions.apply {
            adapter = taskOptionAdapter
        }

        viewModel.firstStageTaskOptions.observe(viewLifecycleOwner){
            taskOptionAdapter.submitList(it)
        }
    }
}