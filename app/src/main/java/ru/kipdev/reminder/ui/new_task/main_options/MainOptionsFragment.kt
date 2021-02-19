package ru.kipdev.reminder.ui.new_task.main_options

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import ru.kipdev.reminder.R
import ru.kipdev.reminder.adapters.createTaskOptionAdapter
import ru.kipdev.reminder.databinding.MainOptionsFragmentBinding

class MainOptionsFragment : Fragment() {

    private lateinit var viewModel: MainOptionsViewModel
    private lateinit var binding: MainOptionsFragmentBinding

    private val taskOptionAdapter by lazy {
        createTaskOptionAdapter{
            if(it.id == 1) navController.navigate(R.id.action_navigation_new_task_to_navigation_place_triggers)
            else navController.navigate(R.id.action_navigation_new_task_to_navigation_time_options)
        }
    }

    private val navController by lazy(LazyThreadSafetyMode.NONE) {
        Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(this).get(MainOptionsViewModel::class.java)

        binding = MainOptionsFragmentBinding.inflate(inflater, container, false)
        binding.rvOptions.apply {
            adapter = taskOptionAdapter
        }

        viewModel.firstStageTaskOptions.observe(viewLifecycleOwner){
            var k = 0
            k++
            taskOptionAdapter.submitList(it)
        }

        return binding.root
    }
}