package com.example.lemonlife

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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

@Preview(showBackground = true)
@Composable
fun LemonLifeApp() {
    LemonLifeTextWithImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center))
}

@Composable
fun LemonLifeTextWithImage(modifier: Modifier = Modifier) {
    var stage by remember {
        mutableStateOf(1)
    }

    var neededClicks = (2..4).random()
    var click = 0

    val textResource = when (stage) {
        1 -> R.string.stage_1
        2 -> R.string.stage_2
        3 -> R.string.stage_3
        else -> R.string.stage_4
    }

    val imageResource = when (stage) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    fun nextStep() {
        if (stage == 2) {
            if (click < neededClicks) {
                click++
            } else {
                click = 0
                neededClicks = (2..4).random()
                stage++
            }
        } else if (stage == 4) {
            stage = 1
        } else {
            stage++
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(text = stringResource(textResource), fontSize = 18.sp)
        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(imageResource),
            contentDescription = "Lemon",
            modifier = Modifier
                .wrapContentSize()
                .border(
                    BorderStroke(2.dp, Color(105, 205, 216)),
                    shape = RoundedCornerShape(4.dp)
                )
                .clickable {
                    nextStep()
                }
        )
    }
}

