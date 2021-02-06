package com.example.reminder.adapters

import android.view.View
import com.example.reminder.databinding.ItemTaskOptionBinding
import com.example.reminder.model.TaskOptionPresentation
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