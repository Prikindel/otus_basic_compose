package ru.prike.otuscomposebasic.presenter

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class NavigationViewModel : ViewModel() {
    private val _showDetail = MutableStateFlow(false)
    val showDetail: StateFlow<Boolean> = _showDetail.asStateFlow()

    fun navigateToDetail() {
        _showDetail.value = true
    }

    fun navigateBack() {
        _showDetail.value = false
    }
}