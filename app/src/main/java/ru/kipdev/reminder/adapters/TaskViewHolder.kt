package ru.kipdev.reminder.adapters

import android.view.View
import me.ibrahimyilmaz.kiel.core.RecyclerViewHolder
import ru.kipdev.domain.model.Task
import ru.kipdev.reminder.databinding.ItemTaskBinding

internal class TaskViewHolder(
    view: View
) : RecyclerViewHolder<Task>(view) {
    val binding = ItemTaskBinding.bind(view)
    override fun bind(position: Int, item: Task) {
        super.bind(position, item)
        binding.tvName.text = item.name
        binding.executePendingBindings()
    }
}