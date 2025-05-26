package ru.prike.otuscomposebasic

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.prike.otuscomposebasic.ui.theme.OtusComposeBasicTheme

@Composable
fun Counter(
    count: Int,
    modifier: Modifier = Modifier,
    onClickPlus: () -> Unit = {},
    onClickMinus: () -> Unit = {},
    onClickReset: () -> Unit = {},
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Clicks: $count",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row {
            Button(
                onClick = onClickPlus
            ) {
                Text(
                    text = "+",
                )
            }
            Button(
                onClick = onClickMinus
            ) {
                Text(
                    text = "-",
                )
            }
            Button(
                onClick = onClickReset
            ) {
                Text(
                    text = "Reset",
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun CounterPreview() {
    OtusComposeBasicTheme {
        Box(
            modifier = Modifier.size(300.dp)
        ) {
            Counter(
                count = 10
            )
        }
    }
}