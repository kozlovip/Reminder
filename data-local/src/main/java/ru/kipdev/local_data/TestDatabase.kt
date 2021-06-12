package ru.kipdev.local_data

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.kipdev.local_data.dao.TestDao
import ru.kipdev.local_data.model.TestEntitiy

@Database(entities = [TestEntitiy::class], version = 1, exportSchema = false)
abstract class TestDatabase : RoomDatabase()  {
    abstract fun testDao() : TestDao
}