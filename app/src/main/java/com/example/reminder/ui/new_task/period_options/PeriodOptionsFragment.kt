package com.example.reminder.ui.new_task.period_options

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.reminder.R

class PeriodOptionsFragment : Fragment() {

    companion object {
        fun newInstance() = PeriodOptionsFragment()
    }

    private lateinit var viewModel: PeriodOptionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.period_options_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PeriodOptionsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}