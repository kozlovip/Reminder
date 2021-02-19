package ru.kipdev.reminder.ui.new_task.place_triggers

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import ru.kipdev.reminder.R

class PlaceTriggersFragment : Fragment() {

    companion object {
        fun newInstance() = PlaceTriggersFragment()
    }

    private lateinit var viewModel: PlaceTriggersViewModel

    private val navController by lazy(LazyThreadSafetyMode.NONE) {
        Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.place_triggers_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PlaceTriggersViewModel::class.java)
        // TODO: Use the ViewModel
    }

}