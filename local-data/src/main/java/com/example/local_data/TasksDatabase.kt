package com.example.local_data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.local_data.dao.TasksDao
import com.example.local_data.model.*

@Database(entities = [TaskEntity::class, TimeTriggerEntity::class, GeoTriggerEntity::class, DeclineConditionEntity::class, DeclineRepeationEntity::class, DismissRepeationEntity::class, PlaceTriggerEntity::class, PlaceEntity::class], version = 1, exportSchema = false)
abstract class TasksDatabase : RoomDatabase() {
    abstract fun tasksDao(): TasksDao
}