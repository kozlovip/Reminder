package com.example.reminder.ui.new_task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.reminder.R
import com.example.reminder.adapters.createTaskOptionAdapter
import com.example.reminder.databinding.FragmentNewTaskBinding
import com.example.reminder.model.TaskOptionPresentation

class NewTaskFragment : Fragment() {

    private lateinit var newTaskViewModel: NewTaskViewModel

    private lateinit var binding: FragmentNewTaskBinding

    private val taskOptionAdapter by lazy {
        createTaskOptionAdapter{
            var k = 0
            k++
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        newTaskViewModel =
                ViewModelProvider(this).get(NewTaskViewModel::class.java)
        binding = FragmentNewTaskBinding.inflate(inflater, container, false)
        binding.rvOptions.apply {
            adapter = taskOptionAdapter
        }

        val l = ArrayList<TaskOptionPresentation>()
        for(i in 0..5)
            l.add(TaskOptionPresentation(i, R.string.app_name, R.drawable.ic_dashboard_black_24dp))

        taskOptionAdapter.submitList(l)
        return binding.root
    }
}