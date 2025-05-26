package ru.prike.otuscomposebasic.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.prike.otuscomposebasic.presenter.CounterViewModel

@Composable
fun DetailScreen(
    counterViewModel: CounterViewModel,
    onNavigateBack: () -> Unit
) {
    val count = counterViewModel.count.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Info"
                )
                Spacer(Modifier.width(8.dp))
                Text(text = "Current count is $count")
            }
        }
        Spacer(Modifier.height(24.dp))
        Button(onClick = onNavigateBack) {
            Text("Back")
        }
    }
}