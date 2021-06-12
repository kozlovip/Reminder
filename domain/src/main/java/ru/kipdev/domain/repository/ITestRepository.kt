package ru.kipdev.domain.repository

interface ITestRepository {
    fun insertTest(time: String, log: String)
}