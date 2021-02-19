package ru.kipdev.reminder.ui.new_task.dismiss_options

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.kipdev.reminder.R

class DismissOptionsFragment : Fragment() {

    companion object {
        fun newInstance() = DismissOptionsFragment()
    }

    private lateinit var viewModel: DismissOptionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dismiss_options_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DismissOptionsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}