package ru.kipdev.reminder.adapters

import ru.kipdev.reminder.R
import ru.kipdev.reminder.model.TaskOptionPresentation
import me.ibrahimyilmaz.kiel.adapterOf

internal inline fun createTaskOptionAdapter(noinline onClick: (TaskOptionPresentation) -> Unit) =
        adapterOf<TaskOptionPresentation> {
            diff(
                    areItemsTheSame = { old, new -> old === new },
                    areContentsTheSame = { old, new ->
                        old.id == new.id
                    }
            )
            register(
                    layoutResource = R.layout.item_task_option,
                    viewHolder = ::TaskOptionViewHolder,
                    onBindViewHolder = { vh, _, presentation ->
                        vh.binding.taskOption = presentation
                        vh.binding.mainConstraintLayout.setOnClickListener {
                            onClick(presentation)
                        }
                    }
            )
        }