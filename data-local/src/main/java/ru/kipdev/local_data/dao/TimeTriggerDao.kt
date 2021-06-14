package ru.kipdev.local_data.dao

import androidx.room.Dao
import ru.kipdev.local_data.model.TimeTriggerEntity

@Dao
interface TimeTriggerDao : BaseDao<TimeTriggerEntity> {
}