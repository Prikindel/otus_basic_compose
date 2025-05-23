package ru.prike.otuscomposebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.prike.otuscomposebasic.data.InMemoryCounterRepository
import ru.prike.otuscomposebasic.presenter.CounterViewModel
import ru.prike.otuscomposebasic.presenter.NavigationViewModel
import ru.prike.otuscomposebasic.ui.CounterScreen
import ru.prike.otuscomposebasic.ui.DetailScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val repository = InMemoryCounterRepository()
        setContent {
            val counterVm: CounterViewModel = viewModel(
                factory = CounterViewModel.Factory(repository)
            )
            val navVm: NavigationViewModel = viewModel()

            val showDetail = navVm.showDetail.collectAsState().value
            if (showDetail) {
                DetailScreen(
                    counterViewModel = counterVm,
                    onNavigateBack = { navVm.navigateBack() }
                )
            } else {
                CounterScreen(
                    counterViewModel = counterVm,
                    onNavigateToDetail = { navVm.navigateToDetail() }
                )
            }
        }
    }
}