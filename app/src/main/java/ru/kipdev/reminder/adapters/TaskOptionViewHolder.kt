package ru.kipdev.reminder.adapters

import android.view.View
import ru.kipdev.reminder.databinding.ItemTaskOptionBinding
import ru.kipdev.reminder.model.TaskOptionPresentation
import me.ibrahimyilmaz.kiel.core.RecyclerViewHolder

internal class TaskOptionViewHolder(
    view: View
) : RecyclerViewHolder<TaskOptionPresentation>(view) {
    val binding = ItemTaskOptionBinding.bind(view)
    override fun bind(position: Int, item: TaskOptionPresentation) {
        super.bind(position, item)
        binding.executePendingBindings()
    }
}