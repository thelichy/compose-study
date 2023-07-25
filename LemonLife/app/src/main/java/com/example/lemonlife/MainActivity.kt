package com.example.lemonlife

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonlife.ui.theme.LemonLifeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonLifeTheme {
                LemonLifeApp()
            }
        }
    }
}


@Preview (showBackground = true)
@Composable
fun LemonLifeApp(modifier: Modifier = Modifier) {
    var stage by remember { mutableStateOf(0) }
    var clicks = 0
    var neededClicks = (2..4).random()


    val image = when(stage) {
        0 -> R.drawable.lemon_tree
        1 -> R.drawable.lemon_squeeze
        2 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val text = when (stage) {
        0 -> "Tap the lemon tree to select a lemon"
        1 -> "Keep tapping the lemon to squeeze it"
        2 -> "Tap the lemonade to drink it"
        else -> "Tap the empty glass to start again"
    }

    fun nextStep() {
        when(stage) {
            1 -> {
                if (clicks < neededClicks) {
                    clicks++
                } else {
                    clicks = 0
                    neededClicks = (2..4).random()
                    stage++
                }
            }
            3 -> {
                stage = 0
            }
            else -> stage++
        }
    }



    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { nextStep() }) {
            Image(
                painterResource(image),
                contentDescription = null,
                modifier = Modifier.wrapContentSize()
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = text, fontSize = 18.sp)
    }
}
