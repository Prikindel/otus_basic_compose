package ru.prike.otuscomposebasic.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.prike.otuscomposebasic.data.CounterRepository

class CounterViewModel(
    private val repository: CounterRepository
) : ViewModel() {

    private val _count = MutableStateFlow(0)
    val count: StateFlow<Int> = _count.asStateFlow()

    init {
        viewModelScope.launch {
            _count.value = repository.getInitialCount()
        }
    }

    fun increment() {
        val new = _count.value + 1
        _count.value = new
        viewModelScope.launch { repository.saveCount(new) }
    }

    fun decrement() {
        val new = (_count.value - 1).coerceAtLeast(0)
        _count.value = new
        viewModelScope.launch { repository.saveCount(new) }
    }

    fun reset() {
        _count.value = 0
        viewModelScope.launch { repository.clear() }
    }

    class Factory(
        private val repository: CounterRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CounterViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return CounterViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}