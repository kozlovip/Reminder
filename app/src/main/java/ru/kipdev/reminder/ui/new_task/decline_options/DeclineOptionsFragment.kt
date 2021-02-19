package ru.kipdev.reminder.ui.new_task.decline_options

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.kipdev.reminder.R

class DeclineOptionsFragment : Fragment() {

    companion object {
        fun newInstance() = DeclineOptionsFragment()
    }

    private lateinit var viewModel: DeclineOptionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.decline_options_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DeclineOptionsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}