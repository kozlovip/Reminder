package ru.kipdev.local_data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "time_triggers",
    foreignKeys = [
        ForeignKey(entity = TaskEntity::class,
            parentColumns = ["id"],
            childColumns = ["task_id"], onDelete = ForeignKey.CASCADE)
    ])
data class TimeTriggerEntity (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "task_id", index = true) val taskId: Int,
    val name: String,
    val delay: Int
)