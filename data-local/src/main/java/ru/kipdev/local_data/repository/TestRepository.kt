package ru.kipdev.local_data.repository

import ru.kipdev.domain.repository.ITestRepository
import ru.kipdev.local_data.dao.TestDao
import ru.kipdev.local_data.model.TestEntitiy

class TestRepository(private val testDao: TestDao) : ITestRepository {
    override fun insertTest(time: String, log: String) {
        testDao.insert(TestEntitiy(0, time, log))
    }
}