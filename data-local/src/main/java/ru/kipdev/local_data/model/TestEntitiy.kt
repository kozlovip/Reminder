package ru.kipdev.local_data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "test")
data class TestEntitiy (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val time: String,
    val log: String
)