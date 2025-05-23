package ru.prike.otuscomposebasic.data

interface CounterRepository {
    suspend fun getInitialCount(): Int
    suspend fun saveCount(value: Int)
    suspend fun clear()
}