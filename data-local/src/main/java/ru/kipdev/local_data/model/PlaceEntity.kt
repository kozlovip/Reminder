package ru.kipdev.local_data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "places")
data class PlaceEntity (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "place_id", index = true) val placeId: Int,
    val name: String,
    val latitude: Double,
    val longitude: Double
)