package ru.prike.otuscomposebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.prike.otuscomposebasic.data.InMemoryCounterRepository
import ru.prike.otuscomposebasic.presenter.CounterViewModel
import ru.prike.otuscomposebasic.presenter.NavigationViewModel
import ru.prike.otuscomposebasic.ui.CounterScreen
import ru.prike.otuscomposebasic.ui.DetailScreen
import ru.prike.otuscomposebasic.ui.theme.OtusComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()

//        setContent {
//            OtusComposeBasicTheme {
//                var count by rememberSaveable { mutableStateOf(0) }
//                Counter(
//                    count = count,
//                    onClickPlus = { count++ },
//                    onClickMinus = {
//                        if (count > 0) {
//                            count--
//                        }
//                    },
//                    onClickReset = { count = 0 }
//                )
//            }
//        }

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