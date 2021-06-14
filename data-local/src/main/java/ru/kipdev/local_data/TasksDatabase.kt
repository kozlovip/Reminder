package ru.kipdev.local_data

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.kipdev.local_data.dao.*
import ru.kipdev.local_data.model.*

@Database(entities = [TaskEntity::class, TimeTriggerEntity::class, GeoTriggerEntity::class, DeclineConditionEntity::class, DeclineReiterationEntity::class, DismissReiterationEntity::class, PlaceTriggerEntity::class, PlaceEntity::class], version = 1, exportSchema = false)
abstract class TasksDatabase : RoomDatabase() {
    abstract fun tasksDao(): TasksDao
    abstract fun declineConditionDao(): DeclineConditionDao
    abstract fun declineReiterationDao(): DeclineReiterationDao
    abstract fun dismissReiterationDao(): DismissReiterationDao
    abstract fun geoTriggerDao(): GeoTriggerDao
    abstract fun placeDao(): PlaceDao
    abstract fun placeTriggerDao(): PlaceTriggerDao
    abstract fun timeTriggerDao(): TimeTriggerDao
}