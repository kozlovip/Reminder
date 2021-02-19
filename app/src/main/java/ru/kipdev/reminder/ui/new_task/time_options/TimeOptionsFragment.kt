package ru.kipdev.reminder.ui.new_task.time_options

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.kipdev.reminder.R
import ru.kipdev.reminder.databinding.MainOptionsFragmentBinding
import ru.kipdev.reminder.databinding.TimeOptionsFragmentBinding

class TimeOptionsFragment : Fragment() {

    companion object {
        fun newInstance() = TimeOptionsFragment()
    }

    private lateinit var viewModel: TimeOptionsViewModel
    private lateinit var binding: TimeOptionsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TimeOptionsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*val callback = SingleDayPickCallback { day ->
            // TODO
        }

        val today = CivilCalendar()

        val datePicker = PrimeDatePicker.bottomSheetWith(today)
                .pickSingleDay(callback)
                .initiallyPickedSingleDay(pickedDay)
                .build()

        datePicker.show(supportFragmentManager, "SOME_TAG")*/
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TimeOptionsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}