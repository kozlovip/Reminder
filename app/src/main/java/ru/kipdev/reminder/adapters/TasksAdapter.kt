package ru.kipdev.reminder.adapters

import me.ibrahimyilmaz.kiel.adapterOf
import ru.kipdev.domain.model.Task
import ru.kipdev.reminder.R

internal fun createTasksAdapter(onClick: (Task) -> Unit) = adapterOf<Task> {
    diff(
        areItemsTheSame = { old, new -> old.id == new.id },
        areContentsTheSame = { old, new -> old.id == new.id }
    )
    register(
        layoutResource = R.layout.item_task,
        viewHolder = ::TaskViewHolder,
        onBindViewHolder = { viewHolder, _, item ->
            viewHolder.itemView.setOnClickListener { onClick(item) }
        }
    )
}