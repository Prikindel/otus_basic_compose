package ru.prike.otuscomposebasic.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.prike.otuscomposebasic.presenter.CounterViewModel

@Composable
fun CounterScreen(
    counterViewModel: CounterViewModel,
    onNavigateToDetail: () -> Unit
) {
    val count = counterViewModel.count.collectAsState().value

    CounterComponent(
        count = count,
        onClickPlus = { counterViewModel.increment() },
        onClickMinus = { counterViewModel.decrement() },
        onClickReset = { counterViewModel.reset() },
        onNavigateToDetail = onNavigateToDetail
    )
}

@Composable
private fun CounterComponent(
    count: Int,
    modifier: Modifier = Modifier,
    onClickPlus: () -> Unit = {},
    onClickMinus: () -> Unit = {},
    onClickReset: () -> Unit = {},
    onNavigateToDetail: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Count: $count")
        Spacer(Modifier.height(8.dp))
        Row {
            Button(onClick = onClickPlus) {
                Text("+")
            }
            Spacer(Modifier.width(8.dp))
            Button(onClick = onClickMinus) {
                Text("-")
            }
            Spacer(Modifier.width(8.dp))
            Button(onClick = onClickReset) {
                Text("Reset")
            }
        }
        Spacer(Modifier.height(16.dp))
        Button(onClick = onNavigateToDetail) {
            Text("Go to Details")
        }
    }
}