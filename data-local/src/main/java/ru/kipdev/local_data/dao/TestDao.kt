package ru.kipdev.local_data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow
import ru.kipdev.local_data.model.TestEntitiy

@Dao
interface TestDao : BaseDao<TestEntitiy> {
    @Transaction
    @Query("SELECT * FROM test")
    fun getAll(): Flow<List<TestEntitiy>>
}