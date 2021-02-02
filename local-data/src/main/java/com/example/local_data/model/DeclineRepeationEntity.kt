package com.example.local_data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "decline_repeations",
    foreignKeys = [
        ForeignKey(entity = TaskEntity::class,
            parentColumns = ["id"],
            childColumns = ["task_id"], onDelete = ForeignKey.CASCADE)
    ])
data class DeclineRepeationEntity (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "task_id") val taskId: Int,
    val times: Int = 0,
    val delay: Int = 0
)