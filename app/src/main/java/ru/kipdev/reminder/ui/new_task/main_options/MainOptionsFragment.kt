package ru.kipdev.reminder.ui.new_task.main_options

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import ru.kipdev.reminder.R
import ru.kipdev.reminder.adapters.createTaskOptionAdapter
import ru.kipdev.reminder.databinding.FragmentMainOptionsBinding
import ru.medicalapps.medicalapps.demo.utils.BaseViewModelFragment

class MainOptionsFragment : BaseViewModelFragment<FragmentMainOptionsBinding, MainOptionsViewModel>() {

    override val layoutId: Int
        get() = R.layout.fragment_main_options

    override val navigationId: Int
        get() = R.id.navigation_new_task

    private val taskOptionAdapter by lazy {
        createTaskOptionAdapter{
            if(it.id == 1) navController.navigate(R.id.action_navigation_new_task_to_navigation_place_triggers)
            else navController.navigate(R.id.action_navigation_new_task_to_navigation_time_options)

        }
    }

    private val navController by lazy(LazyThreadSafetyMode.NONE) {
        Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
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