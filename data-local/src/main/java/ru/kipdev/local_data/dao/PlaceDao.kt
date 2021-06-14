package ru.kipdev.local_data.dao

import androidx.room.Dao
import ru.kipdev.local_data.model.PlaceEntity

@Dao
interface PlaceDao : BaseDao<PlaceEntity> {
}