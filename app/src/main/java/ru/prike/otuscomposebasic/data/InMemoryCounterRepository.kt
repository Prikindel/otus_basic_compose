package ru.prike.otuscomposebasic.data

import kotlinx.coroutines.delay

class InMemoryCounterRepository : CounterRepository {
    private var storedCount: Int = 0

    override suspend fun getInitialCount(): Int {
        delay(500)
        return storedCount
    }

    override suspend fun saveCount(value: Int) {
        delay(300)
        storedCount = value
    }

    override suspend fun clear() {
        delay(300)
        storedCount = 0
    }
}