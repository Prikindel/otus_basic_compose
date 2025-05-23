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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Count: $count")
        Spacer(Modifier.height(8.dp))
        Row {
            Button(onClick = { counterViewModel.increment() }) {
                Text("+")
            }
            Spacer(Modifier.width(8.dp))
            Button(onClick = { counterViewModel.decrement() }) {
                Text("-")
            }
            Spacer(Modifier.width(8.dp))
            Button(onClick = { counterViewModel.reset() }) {
                Text("Reset")
            }
        }
        Spacer(Modifier.height(16.dp))
        Button(onClick = onNavigateToDetail) {
            Text("Go to Details")
        }
    }
}